package com.documents.controller;

import com.documents.model.StudentDetails;
import com.documents.repository.StudentRepository;
import com.documents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
public class StudentController {

    @Autowired
    private UserService userService;

    @Autowired
    StudentRepository userRepository;


//    @PostMapping("/login")
//    public ResponseEntity<StudentDetails> createUser(@RequestBody StudentDetails studentDetails)
//    {
//        boolean f =userService.checkId(studentDetails.getStudentId());
//        if(f)
//        {
//            studentDetails.setEmailId(studentDetails.getEmailId());
//            studentDetails.setName(studentDetails.getName());
//        }
//        else {
//            StudentDetails studentDetails1 = userService.createUser(studentDetails);
//            return new ResponseEntity<>(studentDetails1, HttpStatus.OK);
//        }
//
//
//    }

    @PostMapping("/login")
    public ResponseEntity<?> addStudent(@RequestBody StudentDetails student) {
        try {
            boolean f = userService.checkId(student.getStudentId());
            if(f)
            {
                student.setName(student.getName());
                student.setEmailId(student.getEmailId());
                userRepository.save(student);
                return new ResponseEntity<>(student, null, HttpStatus.OK);
            } else {
                userRepository.save(student);
                return new ResponseEntity<StudentDetails>(student, null, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @PutMapping("/student/{id}")
//    public ResponseEntity<?> updateById(@PathVariable("id") int id, @RequestBody StudentDetails student) {
//        try {
//            boolean f = userService.checkId(id);
//            if(f)
//             {
//                student.setName(student.getName());
//                student.setEmailId(student.getEmailId());
//                userRepository.save(student);
//                return new ResponseEntity<>(student, null, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("No Student found with id: " + id, null, HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }



}
