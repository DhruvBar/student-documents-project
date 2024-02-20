package com.documents.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.documents.model.AdminDetails;

public interface AdminRepo extends JpaRepository<AdminDetails, Integer> {
}
