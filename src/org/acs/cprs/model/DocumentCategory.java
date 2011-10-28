package org.acs.cprs.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cprs_document_categories")
public class DocumentCategory extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String categoryName;
	private Set<DocumentType> types = new HashSet<DocumentType>();
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="category_name")
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@OneToMany(mappedBy="category",targetEntity=DocumentType.class,
		       fetch=FetchType.EAGER)
	public Set<DocumentType> getTypes() {
		return types;
	}
	
	public void setTypes(Set<DocumentType> types) {
		this.types = types;
	}
	
}
