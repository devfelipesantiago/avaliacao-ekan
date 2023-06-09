package com.ekan.ekan.Repositories;

import com.ekan.ekan.Models.Beneficiary;
import org.springframework.data.repository.CrudRepository;

public interface BeneficiaryRepository extends CrudRepository<Beneficiary, Long> {

    Beneficiary getOne(Long id);

    Beneficiary findByName(String name);
}
