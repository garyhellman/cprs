package org.acs.cprs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.acs.cprs.model.StudentReviewerAssignment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ReviewerAssignmentServiceTest {

    @Autowired
    private ReviewerAssignmentService assignmentService;

    @Test
    void runAssignmentRulesAssignsAllSeededStudents() {
        List<StudentReviewerAssignment> assignments = assignmentService.runAssignmentRules();

        assertFalse(assignments.isEmpty());
        assertEquals(10, assignments.size());

        Set<Long> reviewerIds = assignments.stream()
                .map(StudentReviewerAssignment::getReviewerId)
                .collect(Collectors.toSet());
        assertFalse(reviewerIds.isEmpty());

        assignments.forEach(assignment -> {
            assertTrue(assignment.getMatchedRule() != null && !assignment.getMatchedRule().isBlank());
            assertTrue(assignment.getReviewerName() != null && !assignment.getReviewerName().isBlank());
        });
    }
}
