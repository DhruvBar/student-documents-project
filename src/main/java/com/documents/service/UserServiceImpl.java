package com.documents.service;

import com.documents.model.studentDetails;
import com.documents.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private studentRepository StudentRepository;

    @Override
    public studentDetails createUser(studentDetails student)
    {
        student.setName(student.getName());
        student.setStudentId(student.getStudentId());
        student.setContactNo(student.getContactNo());
        student.setEmailId(student.getEmailId());
        return StudentRepository.save(student);

    }

}
