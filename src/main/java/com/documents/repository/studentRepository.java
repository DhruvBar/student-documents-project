package com.documents.repository;

import com.documents.model.studentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface studentRepository extends JpaRepository<studentDetails, Integer> {

}
