package org.acs.cprs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.acs.cprs.dao.AcademicInstitutionDAO;
import org.acs.cprs.model.AcademicInstitution;

/**
 * AcademicInstitution Service
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
@Service
public class AcademicInstitutionService {
	
	private AcademicInstitutionDAO academicInstitutionDAO;

	/**
	 * Get all academicInstitutions
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<AcademicInstitution> getAcademicInstitutionList(int start, int limit){
		
		return academicInstitutionDAO.getAcademicInstitutions(start, limit);
	}
	
	/**
	 * Create new AcademicInstitution/AcademicInstitutions
	 * @param data - json data from request
	 * @return created academicInstitutions
	 */
	@Transactional
	public List<AcademicInstitution> create(AcademicInstitution academicInstitution){
		
        List<AcademicInstitution> newAcademicInstitutions = new ArrayList<AcademicInstitution>();
		
		newAcademicInstitutions.add(academicInstitutionDAO.saveAcademicInstitution(academicInstitution));
		
		return newAcademicInstitutions;
	}
	
	
	/**
	 * Update academicInstitution/academicInstitutions
	 * @param data - json data from request
	 * @return updated academicInstitutions
	 */
	@Transactional
	public List<AcademicInstitution> update(AcademicInstitution academicInstitution){
		
		List<AcademicInstitution> returnAcademicInstitutions = new ArrayList<AcademicInstitution>();
		
		returnAcademicInstitutions.add(academicInstitutionDAO.saveAcademicInstitution(academicInstitution));
		
		return returnAcademicInstitutions;
	}
	
	/**
	 * Delete academicInstitution/academicInstitutions
	 * @param academicInstitution - json data from request
	 */
	@Transactional
	public void delete(AcademicInstitution academicInstitution){
		
		academicInstitutionDAO.deleteAcademicInstitution(academicInstitution.getId());
	}
	
	/**
	 * Get total of AcademicInstitutions from database.
	 * Need to set this value on ExtJS Store
	 * @return
	 */
	public int getTotalAcademicInstitutions(){

		return academicInstitutionDAO.getTotalAcademicInstitutions();
	}

	/**
	 * Spring use - DI
	 * @param academicInstitutionDAO
	 */
	@Autowired
	public void setAcademicInstitutionDAO(AcademicInstitutionDAO academicInstitutionDAO) {
		this.academicInstitutionDAO = academicInstitutionDAO;
	}
	
}
