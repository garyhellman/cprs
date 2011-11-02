package org.acs.cprs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import org.acs.cprs.model.AcademicInstitution;

/**
 * AcademicInstitution DAO class.
 * 
 * Sample project presented at BrazilJS
 * Brazilian JavaScript Conference
 * Fortaleza - Ceará - 13-14 May 2011
 * http://braziljs.com.br/2011
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Repository
public class AcademicInstitutionDAO {
	
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	/**
	 * Get List of academicInstitutions from database
	 * @return list of all academicInstitutions
	 */
	@SuppressWarnings("unchecked")
	public List<AcademicInstitution> getAcademicInstitutions(int start, int limit) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(AcademicInstitution.class);

		return hibernateTemplate.findByCriteria(criteria, start, limit);
	}

	/**
	 * Delete a academicInstitution with the id passed as parameter
	 * @param long1
	 */
	public void deleteAcademicInstitution(Long long1){
		Object record = hibernateTemplate.load(AcademicInstitution.class, long1);
		hibernateTemplate.delete(record);
	}
	
	/**
	 * Create a new AcademicInstitution on the database or
	 * Update academicInstitution
	 * @param academicInstitution
	 * @return academicInstitution added or updated in DB
	 */
	public AcademicInstitution saveAcademicInstitution(AcademicInstitution academicInstitution){
		hibernateTemplate.saveOrUpdate(academicInstitution);
		return academicInstitution;
	}
	
	/**
	 * Get total of AcademicInstitutions from database
	 * @return
	 */
	public int getTotalAcademicInstitutions(){
		return DataAccessUtils.intResult(hibernateTemplate.find("SELECT COUNT(*) FROM AcademicInstitution"));
	}

}
