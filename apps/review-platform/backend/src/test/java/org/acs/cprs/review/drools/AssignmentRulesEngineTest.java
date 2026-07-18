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

    private static final long STUDENT_UNIVERSITY = 1L;
    private static final long OTHER_UNIVERSITY = 2L;

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

        ProfessorCandidate strong = candidate(1L, OTHER_UNIVERSITY, "CS", "ai,systems", "TENURED", 5, 1);
        ProfessorCandidate weak = candidate(2L, OTHER_UNIVERSITY, "Math", "stats", "SENIOR", 5, 0);
        ProfessorCandidate full = candidate(3L, OTHER_UNIVERSITY, "CS", "ai", "JUNIOR", 5, 5);

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
        ProfessorCandidate candidate = candidate(10L, OTHER_UNIVERSITY, "CS", "ai", "SENIOR", 5, 0);

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

        ProfessorCandidate heavy = candidate(1L, OTHER_UNIVERSITY, "CS", "systems", "SENIOR", 10, 4);
        ProfessorCandidate light = candidate(2L, OTHER_UNIVERSITY, "CS", "systems", "SENIOR", 10, 1);

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

    @Test
    void excludesProfessorsFromSameUniversity() {
        AssignmentRequest request = baseRequest();
        request.setDepartment("CS");

        ProfessorCandidate sameSchool = candidate(1L, STUDENT_UNIVERSITY, "CS", "ai", "TENURED", 5, 0);
        ProfessorCandidate otherSchool = candidate(2L, OTHER_UNIVERSITY, "CS", "ai", "SENIOR", 5, 1);

        List<AssignmentSuggestion> suggestions = engine.evaluate(
                request,
                List.of(sameSchool, otherSchool),
                List.of()
        );

        assertEquals(1, suggestions.size());
        assertEquals(2L, suggestions.getFirst().getProfessorId());
        assertTrue(sameSchool.getReasons().contains("same university") || !sameSchool.isEligible());
    }

    private static AssignmentRequest baseRequest() {
        AssignmentRequest request = new AssignmentRequest();
        request.setStudentId(100L);
        request.setUniversityId(STUDENT_UNIVERSITY);
        request.setMaxResults(5);
        return request;
    }

    private static ProfessorCandidate candidate(
            Long id,
            Long universityId,
            String department,
            String areas,
            String seniority,
            int max,
            int active
    ) {
        ProfessorCandidate candidate = new ProfessorCandidate();
        candidate.setProfessorId(id);
        candidate.setUniversityId(universityId);
        candidate.setDepartment(department);
        candidate.setResearchAreas(areas);
        candidate.setSeniority(seniority);
        candidate.setMaxActiveReviews(max);
        candidate.setActiveReviewCount(active);
        return candidate;
    }
}
