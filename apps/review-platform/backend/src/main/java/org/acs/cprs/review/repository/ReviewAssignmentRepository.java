package org.acs.cprs.review.repository;

import org.acs.cprs.review.domain.ReviewAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewAssignmentRepository extends JpaRepository<ReviewAssignment, Long> {

    List<ReviewAssignment> findByStudentIdOrderByScoreDesc(Long studentId);
}
