package com.ekan.ekan.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "tb_beneficiarios")
@Table(name = "tb_beneficiarios")
public class Beneficiary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nome")
    private String name;
    @Column(name = "Telefone")
    private String phone;
    @Column(name = "Data_Nascimento")
    private String bornDate;
    @Column(name = "Data_inclusao")
    private LocalDate incluseDate = LocalDate.now();
    @Column(name = "Data_Atualizacao")
    private LocalDate updateDate = LocalDate.now();
    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    private List<Document> documentList = new ArrayList<>();

    @JsonProperty("documentList")
    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Beneficiary that = (Beneficiary) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Beneficiary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", incluseDate=" + incluseDate +
                ", updateDate=" + updateDate +
                ", documentList=" + documentList.size() +
                '}';
    }
}