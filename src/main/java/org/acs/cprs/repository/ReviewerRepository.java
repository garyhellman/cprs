package org.acs.cprs.repository;

import org.acs.cprs.model.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {
}
