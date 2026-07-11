package org.acs.cprs.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "REVIEWER")
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEWER_ID")
    private Long id;

    @Column(name = "REVIEWER_NAME", nullable = false)
    private String name;

    @Column(name = "REVIEWER_PHONE")
    private String phone;

    @Column(name = "REVIEWER_EMAIL")
    private String email;

    @Column(name = "REGION", nullable = false)
    private String region;

    @Column(name = "SPECIALTY", nullable = false)
    private String specialty;

    @Column(name = "MAX_CAPACITY", nullable = false)
    private int maxCapacity = 5;

    @Column(name = "AFFILIATED_SCHOOL_IDS")
    private String affiliatedSchoolIds;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getAffiliatedSchoolIds() {
        return affiliatedSchoolIds;
    }

    public void setAffiliatedSchoolIds(String affiliatedSchoolIds) {
        this.affiliatedSchoolIds = affiliatedSchoolIds;
    }
}
