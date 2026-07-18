package org.acs.cprs.service;

import java.util.List;
import java.util.Optional;

import org.acs.cprs.model.DocumentCategory;
import org.acs.cprs.repository.DocumentCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentCategoryService {

    private final DocumentCategoryRepository documentCategoryRepository;

    public DocumentCategoryService(DocumentCategoryRepository documentCategoryRepository) {
        this.documentCategoryRepository = documentCategoryRepository;
    }

    @Transactional
    public void insertDocumentCategory(DocumentCategory category) {
        documentCategoryRepository.save(category);
    }

    @Transactional
    public void updateDocumentCategory(DocumentCategory category) {
        documentCategoryRepository.save(category);
    }

    @Transactional(readOnly = true)
    public DocumentCategory getActiveDocumentCategory(String categoryName) {
        return documentCategoryRepository.findActiveByName(categoryName).orElse(null);
    }

    @Transactional
    public void deleteCategory(String name) {
        DocumentCategory category = getActiveDocumentCategory(name);
        if (category != null) {
            if (category.getTypes().isEmpty()) {
                category.setDeleteFl("Y");
                documentCategoryRepository.save(category);
            } else {
                throw new RuntimeException("Error: Document category " + name + " cannot be deleted since it is in use");
            }
        }
    }

    @Transactional
    public void deleteCategory(DocumentCategory category) {
        documentCategoryRepository.save(category);
    }

    @Transactional(readOnly = true)
    public List<DocumentCategory> getAllCategories() {
        return documentCategoryRepository.findAllActive();
    }

    @Transactional(readOnly = true)
    public DocumentCategory getDocumentCategory(String categoryName) {
        Optional<DocumentCategory> category = documentCategoryRepository.findByName(categoryName);
        return category.orElse(null);
    }
}
