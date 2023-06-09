package com.ekan.ekan;

import com.ekan.ekan.Models.Beneficiary;
import com.ekan.ekan.Models.Document;
import com.ekan.ekan.Repositories.BeneficiaryRepository;
import com.ekan.ekan.Repositories.DocumentRepository;
import com.ekan.ekan.Services.BeneficiaryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BeneficiaryServiceTest {

    @InjectMocks
    private BeneficiaryService beneficiaryService;

    @Mock
    private BeneficiaryRepository beneficiaryRepository;

    @Mock
    private DocumentRepository documentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateBeneficiary() {
        Beneficiary data = new Beneficiary();
        data.setName("John Doe");
        data.setPhone("1234567890");
        data.setBornDate("01/01/2000");

        Document documentData = new Document();
        documentData.setDocType("Passport");
        documentData.setDescription("Passport description");
        data.getDocumentList().add(documentData);

        beneficiaryService.createBeneficiary(data);

        verify(beneficiaryRepository).save(any(Beneficiary.class));
    }

    @Test
    void testGetAllBeneficiaries() {
        List<Beneficiary> beneficiaries = new ArrayList<>();
        when(beneficiaryRepository.findAll()).thenReturn(beneficiaries);

        List<Beneficiary> result = beneficiaryService.getAllBeneficiaries();

        assertEquals(beneficiaries, result);
        verify(beneficiaryRepository).findAll();
    }

    @Test
    void testGetBeneficiaryDocuments() {
        Long id = 1L;
        List<Document> documents = new ArrayList<>();
        when(documentRepository.findByBeneficiaryId(id)).thenReturn(documents);

        List<Document> result = beneficiaryService.getBeneficiaryDocuments(id);

        assertEquals(documents, result);
        verify(documentRepository).findByBeneficiaryId(id);
    }

    @Test
    void testUpdateBeneficiary() {
        Long id = 1L;
        Beneficiary beneficiaryUpdates = new Beneficiary();
        beneficiaryUpdates.setName("Jane Doe");
        beneficiaryUpdates.setBornDate("02/02/2002");

        Beneficiary beneficiary = new Beneficiary();
        when(beneficiaryRepository.findById(id)).thenReturn(Optional.of(beneficiary));

        Beneficiary result = beneficiaryService.updateBeneficiary(id, beneficiaryUpdates);

        assertEquals("Jane Doe", result.getName());
        assertEquals("02/02/2002", result.getBornDate());
        verify(beneficiaryRepository).findById(id);
        verify(beneficiaryRepository).save(beneficiary);
    }

    @Test
    void testDeleteBeneficiar() {
    };
}