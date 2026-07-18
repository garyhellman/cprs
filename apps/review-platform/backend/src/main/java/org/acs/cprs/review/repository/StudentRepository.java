package org.acs.cprs.review.repository;

import org.acs.cprs.review.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByDeletedFalseOrderByLastNameAsc();

    List<Student> findByUniversityIdAndDeletedFalseOrderByLastNameAsc(Long universityId);

    Optional<Student> findByIdAndDeletedFalse(Long id);
}
