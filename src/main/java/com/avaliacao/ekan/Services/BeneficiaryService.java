package com.avaliacao.ekan.Services;

import com.avaliacao.ekan.Models.Beneficiary;
import com.avaliacao.ekan.Models.Document;
import com.avaliacao.ekan.Repositories.BeneficiaryRepository;
import com.avaliacao.ekan.Repositories.DocumentRepository;
import com.avaliacao.ekan.Services.exceptions.DatabaseException;
import com.avaliacao.ekan.Services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class BeneficiaryService {

    @Autowired
    BeneficiaryRepository beneficiaryRepository;

    @Autowired
    DocumentRepository documentRepository;


    public void createBeneficiary(Beneficiary data) {
        Beneficiary beneficiary = new Beneficiary();

        beneficiary.setName(data.getName());
        beneficiary.setPhone(data.getPhone());
        beneficiary.setBornDate(data.getBornDate());

        for (Document documentData : data.getDocumentList()) {
            Document document = new Document();

            document.setDocType(documentData.getDocType());
            document.setDescription(documentData.getDescription());
            document.setBeneficiary(beneficiary);
            beneficiary.getDocumentList().add(document);
        }

        beneficiaryRepository.save(beneficiary);
    }

    @GetMapping
    public List<Beneficiary> getAllBeneficiaries() {
        return (List<Beneficiary>) beneficiaryRepository.findAll();
    }

    @GetMapping("/{id}/documents")
    public List<Document> getBeneficiaryDocuments(Long id) {
        return documentRepository.findByBeneficiaryId(id);
    }

    @PutMapping("/{id}")
    public Beneficiary updateBeneficiary(Long id, Beneficiary beneficiaryUpdates) {
        Beneficiary beneficiary = beneficiaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Beneficiary not found"));

        beneficiary.setName(beneficiaryUpdates.getName());
        beneficiary.setBornDate(beneficiaryUpdates.getBornDate());

        return beneficiaryRepository.save(beneficiary);
    }

    public void deleteBeneficiary(Long id) {
        try {
            beneficiaryRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
