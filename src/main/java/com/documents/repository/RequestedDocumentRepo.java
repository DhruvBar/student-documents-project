package com.documents.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

import com.documents.model.RequestedDocuments;

public interface RequestedDocumentRepo extends JpaRepository<RequestedDocuments, Integer>{
    public List <RequestedDocuments> findByRequestId(String requestId);
}
