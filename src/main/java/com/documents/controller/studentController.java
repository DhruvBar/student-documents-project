package com.documents.controller;

import com.documents.model.studentDetails;
import com.documents.repository.studentRepository;
import com.documents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class studentController {

    @Autowired
    private UserService userService;

    @Autowired
    studentRepository userRepository;


    @PostMapping("/login")
    public ResponseEntity<studentDetails> createUser(@RequestBody studentDetails studentDetails)
    {
        studentDetails studentDetails1 =userService.createUser(studentDetails);
        return new ResponseEntity<>(studentDetails1, HttpStatus.OK);

    }


}
