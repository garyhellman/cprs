package org.acs.cprs.review.drools.facts;

import java.time.Instant;

public class ExistingReviewLink {

    private Long studentId;
    private Long professorId;
    private Instant reviewedAt;

    public ExistingReviewLink() {
    }

    public ExistingReviewLink(Long studentId, Long professorId, Instant reviewedAt) {
        this.studentId = studentId;
        this.professorId = professorId;
        this.reviewedAt = reviewedAt;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Instant getReviewedAt() {
        return reviewedAt;
    }

    public void setReviewedAt(Instant reviewedAt) {
        this.reviewedAt = reviewedAt;
    }
}
