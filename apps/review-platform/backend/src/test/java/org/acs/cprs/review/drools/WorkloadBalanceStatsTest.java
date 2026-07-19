package org.acs.cprs.review.drools;

import org.acs.cprs.review.drools.facts.ProfessorCandidate;
import org.acs.cprs.review.drools.facts.WorkloadBalanceStats;
import org.acs.cprs.review.drools.service.AssignmentRulesEngine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkloadBalanceStatsTest {

    @Test
    void computesMinMaxAmongCrossUniversityPeersWithCapacity() {
        ProfessorCandidate sameUni = candidate(1L, 1L, 2, 5);
        ProfessorCandidate light = candidate(2L, 2L, 1, 5);
        ProfessorCandidate heavy = candidate(3L, 2L, 4, 5);
        ProfessorCandidate full = candidate(4L, 2L, 5, 5);

        WorkloadBalanceStats stats = AssignmentRulesEngine.buildWorkloadBalanceStats(
                List.of(sameUni, light, heavy, full),
                1L
        );

        assertEquals(2, stats.getCandidateCount());
        assertEquals(1, stats.getMinActiveReviewCount());
        assertEquals(4, stats.getMaxActiveReviewCount());
        assertEquals(3, stats.getSpread());
    }

    @Test
    void returnsZerosWhenNoEligiblePeers() {
        ProfessorCandidate sameUni = candidate(1L, 1L, 0, 5);
        ProfessorCandidate full = candidate(2L, 2L, 3, 3);

        WorkloadBalanceStats stats = AssignmentRulesEngine.buildWorkloadBalanceStats(
                List.of(sameUni, full),
                1L
        );

        assertEquals(0, stats.getCandidateCount());
        assertEquals(0, stats.getMinActiveReviewCount());
        assertEquals(0, stats.getMaxActiveReviewCount());
        assertEquals(0, stats.getSpread());
    }

    private static ProfessorCandidate candidate(Long id, Long universityId, int active, int max) {
        ProfessorCandidate candidate = new ProfessorCandidate();
        candidate.setProfessorId(id);
        candidate.setUniversityId(universityId);
        candidate.setActiveReviewCount(active);
        candidate.setMaxActiveReviews(max);
        return candidate;
    }
}
