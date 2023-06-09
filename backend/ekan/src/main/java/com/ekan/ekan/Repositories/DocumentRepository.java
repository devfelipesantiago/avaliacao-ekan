package com.ekan.ekan.Repositories;


import com.ekan.ekan.Models.Document;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocumentRepository extends CrudRepository<Document, Long> {
    Document getOne(Long id);

    List<Document> findByBeneficiaryId(Long id);
}
