package org.acs.cprs.review.drools.facts;

public class ProfessorCandidate {

    private Long professorId;
    private Long universityId;
    private String department;
    private String researchAreas;
    private String seniority;
    private int maxActiveReviews;
    private int activeReviewCount;
    private boolean eligible = true;
    private double score;
    private StringBuilder reasons = new StringBuilder();

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
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

    public String getResearchAreas() {
        return researchAreas;
    }

    public void setResearchAreas(String researchAreas) {
        this.researchAreas = researchAreas;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public int getMaxActiveReviews() {
        return maxActiveReviews;
    }

    public void setMaxActiveReviews(int maxActiveReviews) {
        this.maxActiveReviews = maxActiveReviews;
    }

    public int getActiveReviewCount() {
        return activeReviewCount;
    }

    public void setActiveReviewCount(int activeReviewCount) {
        this.activeReviewCount = activeReviewCount;
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void addScore(double delta) {
        this.score += delta;
    }

    public String getReasons() {
        return reasons.toString();
    }

    public void addReason(String reason) {
        if (reasons.length() > 0) {
            reasons.append("; ");
        }
        reasons.append(reason);
    }

    public int remainingCapacity() {
        return Math.max(0, maxActiveReviews - activeReviewCount);
    }
}
