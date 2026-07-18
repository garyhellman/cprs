package org.acs.cprs.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACADEMIC_INSTITUTION")
public class AcademicInstitution implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AI_ID")
    private Long id;

    @Column(name = "AI_NAME")
    private String name;

    @Column(name = "AI_DEPT_ID")
    private int deptId;

    @Column(name = "AI_NEXT_REVIEW_YEAR")
    private Date nextReviewYear;

    @Column(name = "AI_DELETE_FLAG")
    private String deleteFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public Date getNextReviewYear() {
        return nextReviewYear;
    }

    public void setNextReviewYear(Date nextReviewYear) {
        this.nextReviewYear = nextReviewYear;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public static Map<String, Object> mapOK(List<AcademicInstitution> institutions) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("total", institutions.size());
        modelMap.put("data", institutions);
        modelMap.put("success", true);
        return modelMap;
    }

    public static Map<String, Object> mapOK(List<AcademicInstitution> institutions, long total) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("total", total);
        modelMap.put("data", institutions);
        modelMap.put("success", true);
        return modelMap;
    }

    public static Map<String, Object> mapError(String msg) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("message", msg);
        modelMap.put("success", false);
        return modelMap;
    }
}
