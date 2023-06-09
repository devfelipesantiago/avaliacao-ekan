package com.ekan.ekan.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tb_documentos")
@Table(name = "tb_documentos")
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Tipo_documento")
    private String docType;
    @Column(name = "Descricao")
    private String description;
    @Column(name = "Data_Inclusao")
    private LocalDate incluseDate = LocalDate.now();
    @Column(name = "Data_atualizacao")
    private LocalDate updateDate = LocalDate.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiary_id")
    @JsonIgnore
    private Beneficiary beneficiary;

    @JsonProperty("docType")
    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Document document = (Document) o;
        return getId() != null && Objects.equals(getId(), document.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", docType='" + docType + '\'' +
                ", description='" + description + '\'' +
                ", includeDate=" + incluseDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
