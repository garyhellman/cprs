package org.acs.cprs.review.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.seed.faker")
public class FakerSeedProperties {

    /**
     * When true, generate additional universities / professors / students on startup
     * if the database is still at (or below) the Flyway demo footprint.
     */
    private boolean enabled = true;

    private int universities = 8;
    private int professorsPerUniversity = 10;
    private int studentsPerUniversity = 25;
    private long seed = 42L;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getUniversities() {
        return universities;
    }

    public void setUniversities(int universities) {
        this.universities = universities;
    }

    public int getProfessorsPerUniversity() {
        return professorsPerUniversity;
    }

    public void setProfessorsPerUniversity(int professorsPerUniversity) {
        this.professorsPerUniversity = professorsPerUniversity;
    }

    public int getStudentsPerUniversity() {
        return studentsPerUniversity;
    }

    public void setStudentsPerUniversity(int studentsPerUniversity) {
        this.studentsPerUniversity = studentsPerUniversity;
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }
}
