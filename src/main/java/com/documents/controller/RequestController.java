package com.documents.controller;

import java.sql.Timestamp;
// import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.documents.model.RequestsDetails;
import com.documents.repository.RequestRepo;

@Controller
@RestController
public class RequestController {
    @Autowired
    RequestRepo requestRepo;

    @GetMapping("/request/get")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getRequest(@RequestParam String requestId) {
        return new ResponseEntity<>(requestRepo.findByRequestId(requestId), null, HttpStatus.OK);
        // return "Request";
    }

    @GetMapping("/request/getAll")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getAllRequest() {
        try {
            return new ResponseEntity<>(requestRepo.findAll(), null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/request/getByStudentId")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getRequestByStudentId(@RequestParam String studentId) {
        try {
            return new ResponseEntity<>(requestRepo.findByStudentId(studentId), null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/request/add")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> addRequest(@RequestBody RequestsDetails request) {
        try {
            String studentId = request.getStudentId();
            LocalDateTime now = LocalDateTime.now();
            Timestamp time = Timestamp.valueOf(now);
            String datePart = now.format(DateTimeFormatter.ofPattern("yyMMddHHmm"));
            String requestId = datePart + studentId.substring(studentId.length() - 5);
            request.setTime(time);
            request.setRequestId(requestId);
            request.setStatus("Pending");
            requestRepo.save(request);
            return new ResponseEntity<>(request, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> searchRequest(@RequestParam String query) {
        try {
            boolean isNumeric = query.chars().allMatch(Character::isDigit);
            if (isNumeric) {
                return new ResponseEntity<>(requestRepo.findByRequestId(query), null, HttpStatus.OK);
            }
            boolean ewxistBystudentId = requestRepo.existStudentId(query);
            if (ewxistBystudentId) {
                return new ResponseEntity<>(requestRepo.findByStudentId(query), null, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, null, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/request/status/update")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> updateRequestStatus(@RequestBody RequestsDetails request) {
        try {
            RequestsDetails requestOp = requestRepo.findByRequestId(request.getRequestId());
            requestOp.setStatus(request.getStatus());
            requestRepo.save(requestOp);
            return new ResponseEntity<>(requestOp, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/request/getbystatus")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getRequestByStatus(@RequestParam String status) {
        try {
            return new ResponseEntity<>(requestRepo.findByStatus(status), null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
