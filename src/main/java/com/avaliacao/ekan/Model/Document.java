package com.avaliacao.ekan.Model;

import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Document {

    private long id;

    private Set<Beneficiary> documentType = new HashSet<>();

    private String description;
    private Date inclusionDate;
    private Date updateDate;
}
