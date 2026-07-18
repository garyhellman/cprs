package org.acs.cprs.repository;

import java.util.List;
import java.util.Optional;

import org.acs.cprs.model.DocumentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocumentCategoryRepository extends JpaRepository<DocumentCategory, Long> {

    @Query("from DocumentCategory d where d.categoryName = :name and d.deleteFl = 'N'")
    Optional<DocumentCategory> findActiveByName(@Param("name") String categoryName);

    @Query("from DocumentCategory d where d.categoryName = :name")
    Optional<DocumentCategory> findByName(@Param("name") String categoryName);

    @Query("from DocumentCategory d where d.deleteFl = 'N'")
    List<DocumentCategory> findAllActive();
}
