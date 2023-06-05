package com.avaliacao.ekan.Repository;

import com.avaliacao.ekan.Model.Beneficiary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends CrudRepository<Beneficiary, Long> {
}
