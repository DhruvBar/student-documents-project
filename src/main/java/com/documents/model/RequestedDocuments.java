package com.documents.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Requested_Documents")
public class RequestedDocuments {
    @Id
    @Column(name = "id")
    @Generated(value = "auto")
    private int id;
    @Column(name = "request_id")
    private String requestId;
    @Column(name = "document_id")
    private int documentId;
    @Column(name = "no_of_copies")
    private int no_of_copies;
}
