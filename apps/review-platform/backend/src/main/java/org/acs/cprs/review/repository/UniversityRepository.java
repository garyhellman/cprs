package org.acs.cprs.review.repository;

import org.acs.cprs.review.domain.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, Long> {

    List<University> findByDeletedFalseOrderByNameAsc();

    Optional<University> findByIdAndDeletedFalse(Long id);
}
