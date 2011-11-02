package org.acs.cprs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
abstract public class BaseEntity {
	
	private String deleteFl;
	private String createdBy;
	private Date createDate;
	private String lastUpdatedBy;
	private Date lastUpdatedDate;
	private int version;
	
	@Version
	@Column(name="version")
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Column(name="created_by")
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="created_date")
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name="last_upd_by")
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	@Column(name="last_upd_date")
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Column(name="delete_fl")
	public String getDeleteFl() {
		return deleteFl;
	}

	public void setDeleteFl(String deleteFl) {
		this.deleteFl = deleteFl;
	}
	
	public static void setBaseFields(BaseEntity baseEntity, String user) {
		if (baseEntity!=null) {
			baseEntity.setCreateDate(new Date());
			baseEntity.setCreatedBy(user);
			baseEntity.setLastUpdatedBy(user);
			baseEntity.setLastUpdatedDate(new Date());
			baseEntity.setDeleteFl("N");
		}
	}
	
	public static void updateBaseFields(BaseEntity baseEntity, String user) {
		if (baseEntity!=null) {
			baseEntity.setLastUpdatedBy(user);
			baseEntity.setLastUpdatedDate(new Date());
		}
	}

}
