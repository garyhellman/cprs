package org.acs.cprs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.acs.cprs.model.AcademicInstitution;
import org.acs.cprs.model.AcademicInstitutionWrapper;
import org.acs.cprs.service.AcademicInstitutionService;
//import org.acs.cprs.util.ExtJSReturn;

/**
 * Controller - Spring
 * 
 */
@Controller
public class AcademicInstitutionController  {

	private AcademicInstitutionService academicInstitutionService;
	private final static Logger logger = LoggerFactory.getLogger(AcademicInstitutionController.class);
	
	@RequestMapping(value="/acadinstitution/view.action")
	public @ResponseBody Map<String,? extends Object> view(@RequestParam int start, @RequestParam int limit) throws Exception {
		logger.debug("AcademicInstitutionController: view:: ");

		try{

			List<AcademicInstitution> academicInstitutions = academicInstitutionService.getAcademicInstitutionList(start,limit);
			
			int total = academicInstitutionService.getTotalAcademicInstitutions();

			return AcademicInstitution.mapOK((List<AcademicInstitution>)academicInstitutions, total);

		} catch (Exception e) {

			return AcademicInstitution.mapError("Error retrieving AcademicInstitutions from database.");
		}
	}
	
	@RequestMapping(value="/acadinstitution/create.action")
	public @ResponseBody Map<String,? extends Object> create(@RequestBody AcademicInstitutionWrapper data) throws Exception {

		try{

			List<AcademicInstitution> academicInstitutions = academicInstitutionService.create(data.getData());

			return AcademicInstitution.mapOK(academicInstitutions);

		} catch (Exception e) {

			return AcademicInstitution.mapError("Error trying to create academicInstitution.");
		}
	}
	
	@RequestMapping(value="/acadinstitution/update.action")
	public @ResponseBody Map<String,? extends Object> update(@RequestBody AcademicInstitutionWrapper data) throws Exception {
		try{

			List<AcademicInstitution> academicInstitutions = academicInstitutionService.update(data.getData());

			return AcademicInstitution.mapOK(academicInstitutions);

		} catch (Exception e) {

			return AcademicInstitution.mapError("Error trying to update academicInstitution.");
		}
	}
	
	@RequestMapping(value="/acadinstitution/delete.action")
	public @ResponseBody Map<String,? extends Object> delete(@RequestBody AcademicInstitutionWrapper data) throws Exception {
		
		try{
			
			academicInstitutionService.delete(data.getData());

			Map<String,Object> modelMap = new HashMap<String,Object>(3);
			modelMap.put("success", true);

			return modelMap;

		} catch (Exception e) {

			return AcademicInstitution.mapError("Error trying to delete academicInstitution.");
		}
	}
	

	@Autowired
	public void setAcademicInstitutionService(AcademicInstitutionService academicInstitutionService) {
		this.academicInstitutionService = academicInstitutionService;
	}

}
