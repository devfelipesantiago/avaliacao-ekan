package com.avaliacao.ekan.Controllers;

import com.avaliacao.ekan.Models.Beneficiary;
import com.avaliacao.ekan.Models.Document;

import com.avaliacao.ekan.Services.BeneficiaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/beneficiaries")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @PostMapping("/")
    public ResponseEntity<List<Document>> createBeneficiary(@RequestBody Beneficiary data) {

        beneficiaryService.createBeneficiary(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(data.getId()).toUri();
        return ResponseEntity.created(uri).body(data.getDocumentList());
    }

    @GetMapping
    public ResponseEntity<List<Beneficiary>> getAllBeneficiaries() {

        List<Beneficiary> beneficiaries = beneficiaryService.getAllBeneficiaries();
        return ResponseEntity.ok().body(beneficiaries) ;
    }

    @GetMapping("/{id}/documents")
    public ResponseEntity<List<Document>> getBeneficiaryDocuments(@PathVariable Long id) {
        return ResponseEntity.ok().body(beneficiaryService.getBeneficiaryDocuments(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beneficiary> updateBeneficiary(@PathVariable Long id, @RequestBody Beneficiary beneficiaryUpdates) {
        return ResponseEntity.ok().body(beneficiaryService.updateBeneficiary(id, beneficiaryUpdates));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Beneficiary> deleteBeneficiary(@PathVariable Long id) {
        beneficiaryService.deleteBeneficiary(id);
        return ResponseEntity.noContent().build();
    }
}