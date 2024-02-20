package com.documents.repository;

import com.documents.model.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<StudentDetails, Integer> {

    public boolean existsById(int studentId);
    public StudentDetails findById(String id);


}
