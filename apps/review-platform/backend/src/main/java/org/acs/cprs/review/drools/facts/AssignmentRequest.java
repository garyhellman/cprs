package org.acs.cprs.review.drools.facts;

public class AssignmentRequest {

    private Long studentId;
    private Long universityId;
    private String department;
    private Integer yearLevel;
    private String interests;
    private int maxResults = 5;
    private int recentReviewLookbackDays = 365;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(Integer yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public int getRecentReviewLookbackDays() {
        return recentReviewLookbackDays;
    }

    public void setRecentReviewLookbackDays(int recentReviewLookbackDays) {
        this.recentReviewLookbackDays = recentReviewLookbackDays;
    }
}
