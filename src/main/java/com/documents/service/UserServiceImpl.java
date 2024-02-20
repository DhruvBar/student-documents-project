package com.documents.service;

import com.documents.model.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private com.documents.repository.StudentRepository studentRepository;

    @Override
    public StudentDetails createUser(StudentDetails student) {
        student.setName(student.getName());
        student.setStudentId(student.getStudentId());
        student.setEmailId(student.getEmailId());
        return studentRepository.save(student);

    }
    @Override
    public boolean checkId(int studentId) {
        return studentRepository.existsById(studentId);
    }


}