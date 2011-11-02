package org.acs.cprs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="cprs_document_types")
public class DocumentType extends BaseEntity implements Serializable {
private static final long serialVersionUID = 1L;
	
	private Long id;
	private String typeName;
	private DocumentCategory category;
	private String requiredFl;
	private String linkAccepted;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="type_name")
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@ManyToOne(optional=false)
    @JoinColumn(name="category_id",referencedColumnName="id")
	public DocumentCategory getCategory() {
		return category;
	}
	
	public void setCategory(DocumentCategory category) {
		this.category = category;
	}
	
	@Column(name="required_fl")
	public String getRequiredFl() {
		return requiredFl;
	}
	
	public void setRequiredFl(String requiredFl) {
		this.requiredFl = requiredFl;
	}

	@Column(name="link_accepted_fl")
	public String getLinkAccepted() {
		return linkAccepted;
	}

	public void setLinkAccepted(String linkAccepted) {
		this.linkAccepted = linkAccepted;
	}

}
