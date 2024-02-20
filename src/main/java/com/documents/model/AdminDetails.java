package com.documents.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="Admin_Details")
public class AdminDetails {


    @Id
    private int adminId;
    private String adminName;
    private String password;
}
