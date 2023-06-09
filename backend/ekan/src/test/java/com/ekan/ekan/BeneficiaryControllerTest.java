package com.ekan.ekan;

import com.ekan.ekan.Controllers.BeneficiaryController;
import com.ekan.ekan.Models.Beneficiary;
import com.ekan.ekan.Models.Document;
import com.ekan.ekan.Services.BeneficiaryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BeneficiaryControllerTest {

    @InjectMocks
    private BeneficiaryController beneficiaryController;

    @Mock
    private BeneficiaryService beneficiaryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateBeneficiary() {
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setId(1L);
        List<Document> documents = new ArrayList<>();
//        when(beneficiaryService.createBeneficiary(beneficiary)).thenReturn((List<Document>) documents);

        ResponseEntity<List<Document>> response = beneficiaryController.createBeneficiary(beneficiary);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(documents, response.getBody());
        verify(beneficiaryService).createBeneficiary(beneficiary);
    }

    @Test
    void testGetAllBeneficiaries() {
        List<Beneficiary> beneficiaries = new ArrayList<>();
        when(beneficiaryService.getAllBeneficiaries()).thenReturn(beneficiaries);

        ResponseEntity<List<Beneficiary>> response = beneficiaryController.getAllBeneficiaries();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(beneficiaries, response.getBody());
        verify(beneficiaryService).getAllBeneficiaries();
    }

    @Test
    void testGetBeneficiaryDocuments() {
        Long id = 1L;
        List<Document> documents = new ArrayList<>();
        when(beneficiaryService.getBeneficiaryDocuments(id)).thenReturn(documents);

        ResponseEntity<List<Document>> response = beneficiaryController.getBeneficiaryDocuments(id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(documents, response.getBody());
        verify(beneficiaryService).getBeneficiaryDocuments(id);
    }

    @Test
    void testUpdateBeneficiary() {
        Long id = 1L;
        Beneficiary beneficiaryUpdates = new Beneficiary();
        when(beneficiaryService.updateBeneficiary(id, beneficiaryUpdates)).thenReturn(beneficiaryUpdates);

        ResponseEntity<Beneficiary> response = beneficiaryController.updateBeneficiary(id, beneficiaryUpdates);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(beneficiaryUpdates, response.getBody());
        verify(beneficiaryService).updateBeneficiary(id, beneficiaryUpdates);
    }

    @Test
    void testDeleteBeneficiary() {
        Long id = 1L;
        ResponseEntity<Beneficiary> response = beneficiaryController.deleteBeneficiary(id);
    }
}
