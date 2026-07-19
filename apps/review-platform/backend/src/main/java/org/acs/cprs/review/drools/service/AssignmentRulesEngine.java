package org.acs.cprs.review.drools.service;

import org.acs.cprs.review.drools.facts.AssignmentRequest;
import org.acs.cprs.review.drools.facts.AssignmentSuggestion;
import org.acs.cprs.review.drools.facts.ExistingReviewLink;
import org.acs.cprs.review.drools.facts.ProfessorCandidate;
import org.acs.cprs.review.drools.facts.WorkloadBalanceStats;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class AssignmentRulesEngine {

    private final KieContainer kieContainer;

    public AssignmentRulesEngine(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public List<AssignmentSuggestion> evaluate(
            AssignmentRequest request,
            List<ProfessorCandidate> candidates,
            List<ExistingReviewLink> existingLinks
    ) {
        KieSession session = kieContainer.newKieSession("assignmentKieSession");
        try {
            session.insert(request);
            session.insert(buildWorkloadBalanceStats(candidates, request.getUniversityId()));
            for (ProfessorCandidate candidate : candidates) {
                session.insert(candidate);
            }
            for (ExistingReviewLink link : existingLinks) {
                session.insert(link);
            }
            session.fireAllRules();

            List<AssignmentSuggestion> suggestions = new ArrayList<>();
            for (ProfessorCandidate candidate : candidates) {
                if (candidate.isEligible()) {
                    suggestions.add(new AssignmentSuggestion(
                            candidate.getProfessorId(),
                            candidate.getScore(),
                            candidate.getReasons(),
                            true
                    ));
                }
            }
            suggestions.sort(Comparator.comparingDouble(AssignmentSuggestion::getScore).reversed());
            int limit = Math.max(1, request.getMaxResults());
            if (suggestions.size() > limit) {
                return suggestions.subList(0, limit);
            }
            return suggestions;
        } finally {
            session.dispose();
        }
    }

    /**
     * Peer load stats among cross-university professors who still have capacity —
     * used by {@code EqualizeStudentReviewLoad} so each professor receives a similar
     * number of student-review assignments. Same-university peers are excluded
     * (they are gated by {@code AvoidSameUniversity}).
     */
    public static WorkloadBalanceStats buildWorkloadBalanceStats(
            List<ProfessorCandidate> candidates,
            Long studentUniversityId
    ) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int count = 0;
        for (ProfessorCandidate candidate : candidates) {
            if (candidate.remainingCapacity() <= 0) {
                continue;
            }
            if (studentUniversityId != null
                    && studentUniversityId.equals(candidate.getUniversityId())) {
                continue;
            }
            count++;
            min = Math.min(min, candidate.getActiveReviewCount());
            max = Math.max(max, candidate.getActiveReviewCount());
        }
        if (count == 0) {
            return new WorkloadBalanceStats(0, 0, 0);
        }
        return new WorkloadBalanceStats(min, max, count);
    }
}
