package com.documents.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.documents.model.DocumentDetails;
import com.documents.model.DocumentDetailsDTO;
import com.documents.repository.DocumentRepo;

@Controller
@RestController
public class DocumentController {

    @Autowired
    DocumentRepo documentRepository;

    @PostMapping("/document/add")
    public String addDocument(@RequestBody DocumentDetails documentDetails) {
        boolean f = documentRepository.existsById(documentDetails.getDocumentId());
        if (f) {
            return "Document already exists";
        } else {
            Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
            documentDetails.setAddedDate(timestamp1);
            documentRepository.save(documentDetails);
            return "Document added successfully";
        }
    }

    @GetMapping("/document/getall")
    public ResponseEntity<?> getAllDocuments() {
        try {
            List<DocumentDetails> documentDetails = documentRepository.findAll();
            return new ResponseEntity<>(documentDetails, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/document/getallwithoutdate")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getAllDocumentsWithoutDate() {
        try {
            List<DocumentDetailsDTO> documentDetailsDTOs = documentRepository.findAll().stream()
                    .map(document -> new DocumentDetailsDTO(document.getDocumentName(),
                            document.getDocumentCost()))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(documentDetailsDTOs, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
