package org.acs.cprs.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private Long id;

    @Column(name = "STUDENT_NAME", nullable = false)
    private String name;

    @Column(name = "INSTITUTION_NAME", nullable = false)
    private String institutionName;

    @Column(name = "AFFILIATED_SCHOOL_ID")
    private String affiliatedSchoolId;

    @Column(name = "REGION", nullable = false)
    private String region;

    @Column(name = "SPECIALTY", nullable = false)
    private String specialty;

    @Column(name = "REVIEW_YEAR")
    private String reviewYear;

    @Column(name = "MEETING_NAME")
    private String meetingName;

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

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getAffiliatedSchoolId() {
        return affiliatedSchoolId;
    }

    public void setAffiliatedSchoolId(String affiliatedSchoolId) {
        this.affiliatedSchoolId = affiliatedSchoolId;
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

    public String getReviewYear() {
        return reviewYear;
    }

    public void setReviewYear(String reviewYear) {
        this.reviewYear = reviewYear;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }
}
