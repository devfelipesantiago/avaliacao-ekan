package com.avaliacao.ekan.Model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Beneficiary {

    private long id;

    private String name;
    private String phone;
    private Date dateBorn;
    private Date inclusionDate;
    private Date updateDate;
}
