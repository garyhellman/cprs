package org.acs.cprs.repository;

import java.util.List;

import org.acs.cprs.model.StudentReviewerAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentReviewerAssignmentRepository extends JpaRepository<StudentReviewerAssignment, Long> {

    List<StudentReviewerAssignment> findByReviewerId(Long reviewerId);
}
