package com.avaliacao.ekan.Repository;

import com.avaliacao.ekan.Model.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  DocumentRepository extends CrudRepository<Document, Long> {
}
