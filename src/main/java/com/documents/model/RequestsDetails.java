package com.documents.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "requests_details")
public class RequestsDetails {
    @Id
    @Column(name = "request_id")
    private String requestId;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "amount_paid")
    private double amountPaid;

    @Column(name = "delivery_mod")
    private String deliveryMod;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "status")
    private String status;
}
