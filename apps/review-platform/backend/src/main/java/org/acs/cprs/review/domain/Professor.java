package org.acs.cprs.review.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    @Column(name = "first_name", nullable = false, length = 128)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 128)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(length = 128)
    private String department;

    @Column(name = "research_areas", length = 512)
    private String researchAreas;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    private Seniority seniority = Seniority.JUNIOR;

    @Column(name = "max_active_reviews", nullable = false)
    private int maxActiveReviews = 5;

    @Column(name = "active_review_count", nullable = false)
    private int activeReviewCount = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Seniority getSeniority() {
        return seniority;
    }

    public void setSeniority(Seniority seniority) {
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
}
