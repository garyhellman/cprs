package org.acs.cprs.review.drools.service;

import org.acs.cprs.review.drools.facts.AssignmentRequest;
import org.acs.cprs.review.drools.facts.AssignmentSuggestion;
import org.acs.cprs.review.drools.facts.ExistingReviewLink;
import org.acs.cprs.review.drools.facts.ProfessorCandidate;
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
}
