package com.documents.controller;

import java.sql.Timestamp;

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

import com.documents.model.PostDetails;
import com.documents.repository.PostRepo;

@Controller
@RestController
public class PostController {
    @Autowired
    PostRepo postRepo;

    @GetMapping("/post/getall")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity <?> getPost() {
        try {
            return new ResponseEntity<>(postRepo.findAll(), null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/post/get")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity <?> getPost(@RequestParam String requestId) {
        try {
            return new ResponseEntity<>(postRepo.findByRequestId(requestId), null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/post/add")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity <?> addPost(@RequestBody PostDetails post) {
        try {
            // Timestamp time = new Timestamp(System.currentTimeMillis());
            // post.setPostTime(time);
            postRepo.save(post);
            return new ResponseEntity<>(post, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
