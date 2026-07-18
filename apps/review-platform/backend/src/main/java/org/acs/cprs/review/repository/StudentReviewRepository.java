package org.acs.cprs.review.repository;

import org.acs.cprs.review.domain.StudentReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentReviewRepository extends JpaRepository<StudentReview, Long> {

    List<StudentReview> findByDeletedFalseOrderByCreatedAtDesc();

    Optional<StudentReview> findByIdAndDeletedFalse(Long id);

    List<StudentReview> findByStudentIdAndDeletedFalse(Long studentId);
}
