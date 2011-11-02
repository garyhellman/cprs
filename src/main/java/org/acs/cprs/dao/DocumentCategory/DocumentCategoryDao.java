package org.acs.cprs.dao.DocumentCategory;

import java.util.List;

import org.acs.cprs.model.DocumentCategory;

public interface DocumentCategoryDao {
	public void insertDocumentCategory(DocumentCategory category);
	public void updateDocumentCategory(DocumentCategory category);
	public DocumentCategory getActiveDocumentCategory(String categoryName);
	public DocumentCategory getDocumentCategory(String categoryName);
	public void deleteCategory(String category);
	public void deleteCategory(DocumentCategory category);
	public List<DocumentCategory> getAllCategories();
}
