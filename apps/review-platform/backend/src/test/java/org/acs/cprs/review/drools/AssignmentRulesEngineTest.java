package org.acs.cprs.review.drools;

import org.acs.cprs.review.drools.facts.AssignmentRequest;
import org.acs.cprs.review.drools.facts.AssignmentSuggestion;
import org.acs.cprs.review.drools.facts.ExistingReviewLink;
import org.acs.cprs.review.drools.facts.ProfessorCandidate;
import org.acs.cprs.review.drools.service.AssignmentRulesEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssignmentRulesEngineTest {

    private AssignmentRulesEngine engine;

    @BeforeEach
    void setUp() {
        KieContainer container = KieServices.Factory.get().getKieClasspathContainer();
        engine = new AssignmentRulesEngine(container);
    }

    @Test
    void ranksDepartmentAndInterestMatchesAboveOthers() {
        AssignmentRequest request = baseRequest();
        request.setDepartment("CS");
        request.setInterests("ai,ml");
        request.setYearLevel(3);

        ProfessorCandidate strong = candidate(1L, "CS", "ai,systems", "TENURED", 5, 1);
        ProfessorCandidate weak = candidate(2L, "Math", "stats", "SENIOR", 5, 0);
        ProfessorCandidate full = candidate(3L, "CS", "ai", "JUNIOR", 5, 5);

        List<AssignmentSuggestion> suggestions = engine.evaluate(
                request,
                List.of(strong, weak, full),
                List.of()
        );

        assertEquals(2, suggestions.size());
        assertEquals(1L, suggestions.getFirst().getProfessorId());
        assertTrue(suggestions.getFirst().getScore() > suggestions.get(1).getScore());
        assertTrue(suggestions.stream().noneMatch(s -> s.getProfessorId() == 3L));
    }

    @Test
    void excludesRecentReviewConflicts() {
        AssignmentRequest request = baseRequest();
        ProfessorCandidate candidate = candidate(10L, "CS", "ai", "SENIOR", 5, 0);

        ExistingReviewLink link = new ExistingReviewLink(
                request.getStudentId(),
                10L,
                Instant.now().minus(10, ChronoUnit.DAYS)
        );

        List<AssignmentSuggestion> suggestions = engine.evaluate(
                request,
                List.of(candidate),
                List.of(link)
        );

        assertTrue(suggestions.isEmpty());
    }

    @Test
    void prefersProfessorWithFewerAssignedStudentsForEqualLoad() {
        AssignmentRequest request = baseRequest();
        request.setDepartment("CS");
        request.setYearLevel(3);

        // Same dept/seniority; only active review load differs
        ProfessorCandidate heavy = candidate(1L, "CS", "systems", "SENIOR", 10, 4);
        ProfessorCandidate light = candidate(2L, "CS", "systems", "SENIOR", 10, 1);

        List<AssignmentSuggestion> suggestions = engine.evaluate(
                request,
                List.of(heavy, light),
                List.of()
        );

        assertEquals(2, suggestions.size());
        assertEquals(2L, suggestions.getFirst().getProfessorId());
        assertTrue(suggestions.getFirst().getScore() > suggestions.get(1).getScore());
        assertTrue(suggestions.getFirst().getReason().contains("equalize load"));
    }

    private static AssignmentRequest baseRequest() {
        AssignmentRequest request = new AssignmentRequest();
        request.setStudentId(100L);
        request.setUniversityId(1L);
        request.setMaxResults(5);
        return request;
    }

    private static ProfessorCandidate candidate(
            Long id,
            String department,
            String areas,
            String seniority,
            int max,
            int active
    ) {
        ProfessorCandidate candidate = new ProfessorCandidate();
        candidate.setProfessorId(id);
        candidate.setUniversityId(1L);
        candidate.setDepartment(department);
        candidate.setResearchAreas(areas);
        candidate.setSeniority(seniority);
        candidate.setMaxActiveReviews(max);
        candidate.setActiveReviewCount(active);
        return candidate;
    }
}
