package org.acs.cprs.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "delete_fl")
    private String deleteFl;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Date createDate;

    @Column(name = "last_upd_by")
    private String lastUpdatedBy;

    @Column(name = "last_upd_date")
    private Date lastUpdatedDate;

    @Version
    @Column(name = "version")
    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getDeleteFl() {
        return deleteFl;
    }

    public void setDeleteFl(String deleteFl) {
        this.deleteFl = deleteFl;
    }

    public static void setBaseFields(BaseEntity baseEntity, String user) {
        if (baseEntity != null) {
            baseEntity.setCreateDate(new Date());
            baseEntity.setCreatedBy(user);
            baseEntity.setLastUpdatedBy(user);
            baseEntity.setLastUpdatedDate(new Date());
            baseEntity.setDeleteFl("N");
        }
    }

    public static void updateBaseFields(BaseEntity baseEntity, String user) {
        if (baseEntity != null) {
            baseEntity.setLastUpdatedBy(user);
            baseEntity.setLastUpdatedDate(new Date());
        }
    }
}
