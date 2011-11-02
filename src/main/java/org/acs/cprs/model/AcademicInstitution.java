package org.acs.cprs.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
@Entity
@Table(name="ACADEMIC_INSTITUTION")
public class AcademicInstitution implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private int deptId;
	private Date nextReviewYear;
	private String deleteFlag;
	
	@Id
	@Column(name="AI_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="AI_NAME")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="AI_DEPT_ID")
	public int getDeptId() {
		return deptId;
	}
	
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	@Column(name="AI_NEXT_REVIEW_YEAR")
	public Date getNextReviewYear() {
		return nextReviewYear;
	}
	
	public void setNextReviewYear(Date nextReviewYear) {
		this.nextReviewYear = nextReviewYear;
	}
	
	@Column(name="AI_DELETE_FLAG")
	public String getDeleteFlag() {
		return deleteFlag;
	}
	
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param contacts
	 * @return
	 */
	public static Map<String,Object> mapOK(List<AcademicInstitution> contacts){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", contacts.size());
		modelMap.put("data", contacts);
		modelMap.put("success", true);
		
		return modelMap;
	}
	
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param contacts
	 * @return
	 */
	public static Map<String,Object> mapOK(List<AcademicInstitution> contacts, int total){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", total);
		modelMap.put("data", contacts);
		modelMap.put("success", true);
		
		return modelMap;
	}
	
	/**
	 * Generates modelMap to return in the modelAndView in case
	 * of exception
	 * @param msg message
	 * @return
	 */
	public static Map<String,Object> mapError(String msg){

		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", false);

		return modelMap;
	} 
	
	

}
