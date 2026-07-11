package org.acs.cprs.rules.model;

/**
 * Mutable fact inserted into the Drools working memory for each student
 * pending reviewer assignment.
 */
public class StudentAssignmentFact {

    private Long studentId;
    private String studentName;
    private String institutionName;
    private String region;
    private String specialty;
    private String affiliatedSchoolId;
    private boolean assigned;
    private Long assignedReviewerId;
    private String assignedReviewerName;
    private String matchedRule;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getAffiliatedSchoolId() {
        return affiliatedSchoolId;
    }

    public void setAffiliatedSchoolId(String affiliatedSchoolId) {
        this.affiliatedSchoolId = affiliatedSchoolId;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public Long getAssignedReviewerId() {
        return assignedReviewerId;
    }

    public void setAssignedReviewerId(Long assignedReviewerId) {
        this.assignedReviewerId = assignedReviewerId;
    }

    public String getAssignedReviewerName() {
        return assignedReviewerName;
    }

    public void setAssignedReviewerName(String assignedReviewerName) {
        this.assignedReviewerName = assignedReviewerName;
    }

    public String getMatchedRule() {
        return matchedRule;
    }

    public void setMatchedRule(String matchedRule) {
        this.matchedRule = matchedRule;
    }
}
