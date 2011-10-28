package org.acs.cprs.dao.DocumentCategory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.acs.cprs.model.DocumentCategory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentCategoryDaoImpl implements DocumentCategoryDao, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(DocumentCategoryDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public DocumentCategoryDaoImpl(SessionFactory sFactory) {
		this.sessionFactory = sFactory;
	}

	@Override
	public void insertDocumentCategory(DocumentCategory category) {
		sessionFactory.getCurrentSession().save(category);
	}

	@Override
	public void updateDocumentCategory(DocumentCategory category) {
		sessionFactory.getCurrentSession().merge(category);
	}

	/**
	 * THis method only return active document category...
	 */
	@Override
	public DocumentCategory getActiveDocumentCategory(String categoryName) {
		log.debug("categoryName=" + categoryName);

		Query query = sessionFactory.getCurrentSession().createQuery("from DocumentCategory where categoryName=:name and deleteFl='N'");
		query.setParameter("name", categoryName);
		List<DocumentCategory> categories = query.list();

		log.debug("size=" + categories.size());
		if (categories.size() == 0) {
			return null;
		} else {
			if (categories.size() == 1) {
				return categories.get(0);
			} else {
				throw new RuntimeException("Error: found more than one category for category " + categoryName);
			}
		}
	}

	@Override
	public void deleteCategory(String name) {
		DocumentCategory category = getActiveDocumentCategory(name);
		if (category != null) {
			if (category.getTypes().size() == 0) {
				category.setDeleteFl("Y");
			} else {
				throw new RuntimeException("Error: Document category " + name + " cannot be deleted since it is in use");
			}
		}

	}

	@Override
	public void deleteCategory(DocumentCategory category) {
		sessionFactory.getCurrentSession().merge(category);
	}

	@Override
	public List<DocumentCategory> getAllCategories() {
		List<DocumentCategory> categories = new ArrayList<DocumentCategory>();
		Query query = sessionFactory.getCurrentSession().createQuery("from DocumentCategory where deleteFl='N'");
		categories = query.list();

		return categories;
	}

	/**
	 * This method will return a cateogry for a given name. The category can be
	 * active, or deleted.
	 */
	@Override
	public DocumentCategory getDocumentCategory(String categoryName) {
		log.debug("categoryName=" + categoryName);

		Query query = sessionFactory.getCurrentSession().createQuery("from DocumentCategory where categoryName=:name");
		query.setParameter("name", categoryName);
		List<DocumentCategory> categories = query.list();

		log.debug("size=" + categories.size());
		if (categories.size() == 0) {
			return null;
		} else {
			if (categories.size() == 1) {
				return categories.get(0);
			} else {
				throw new RuntimeException("Error: found more than one category for category " + categoryName);
			}
		}
	}

}
