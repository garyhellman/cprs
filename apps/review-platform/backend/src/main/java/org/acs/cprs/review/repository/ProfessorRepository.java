package org.acs.cprs.review.repository;

import org.acs.cprs.review.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    List<Professor> findByDeletedFalseOrderByLastNameAsc();

    List<Professor> findByUniversityIdAndDeletedFalseOrderByLastNameAsc(Long universityId);

    Optional<Professor> findByIdAndDeletedFalse(Long id);
}
