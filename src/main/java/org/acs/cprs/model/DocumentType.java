package org.acs.cprs.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cprs_document_types")
public class DocumentType extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private DocumentCategory category;

    @Column(name = "required_fl")
    private String requiredFl;

    @Column(name = "link_accepted_fl")
    private String linkAccepted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public DocumentCategory getCategory() {
        return category;
    }

    public void setCategory(DocumentCategory category) {
        this.category = category;
    }

    public String getRequiredFl() {
        return requiredFl;
    }

    public void setRequiredFl(String requiredFl) {
        this.requiredFl = requiredFl;
    }

    public String getLinkAccepted() {
        return linkAccepted;
    }

    public void setLinkAccepted(String linkAccepted) {
        this.linkAccepted = linkAccepted;
    }
}
