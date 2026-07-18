package org.acs.cprs.review.drools.facts;

public class AssignmentSuggestion {

    private Long professorId;
    private double score;
    private String reason;
    private boolean eligible;

    public AssignmentSuggestion() {
    }

    public AssignmentSuggestion(Long professorId, double score, String reason, boolean eligible) {
        this.professorId = professorId;
        this.score = score;
        this.reason = reason;
        this.eligible = eligible;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }
}
