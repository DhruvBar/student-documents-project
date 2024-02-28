package com.documents.controller;

import java.util.List;

import org.attoparser.dom.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.documents.model.DocumentDetails;
import com.documents.model.RequestedDocuments;
import com.documents.repository.DocumentRepo;
import com.documents.repository.RequestedDocumentRepo;

@Controller
@RestController
public class RequstedDocumentsController {
    @Autowired
    RequestedDocumentRepo requestedDocumentRepo;

    @GetMapping("/requestedDocuments/get")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getRequestedDocuments(@RequestParam String requestId) {
        try {
            return new ResponseEntity<>(requestedDocumentRepo.findByRequestId(requestId), null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/requestedDocuments/add")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> addRequestedDocuments(@RequestBody RequestedDocuments request) {
        try {
            requestedDocumentRepo.save(request);
            return new ResponseEntity<>(request, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
