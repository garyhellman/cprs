package org.acs.cprs.rules.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Mutable fact representing reviewer capacity and affiliation constraints
 * used by Drools assignment rules.
 */
public class ReviewerCapacityFact {

    private Long reviewerId;
    private String reviewerName;
    private String region;
    private String specialty;
    private int maxCapacity;
    private int currentLoad;
    private Set<String> affiliatedSchoolIds = new HashSet<>();

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
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

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }

    public Set<String> getAffiliatedSchoolIds() {
        return affiliatedSchoolIds;
    }

    public void setAffiliatedSchoolIds(Set<String> affiliatedSchoolIds) {
        this.affiliatedSchoolIds = affiliatedSchoolIds;
    }

    public boolean hasCapacity() {
        return currentLoad < maxCapacity;
    }

    public void incrementLoad() {
        currentLoad++;
    }

    public boolean isAffiliatedWith(String schoolId) {
        return schoolId != null && affiliatedSchoolIds.contains(schoolId);
    }
}
