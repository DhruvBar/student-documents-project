package com.documents.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Student_Details")
public class studentDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Request_ID")
    private Long requestId;
    @Column(name = "Student_ID")
    private int studentId;
    @Column(name = "Email")
    private String emailId;
    @Column(name = "Student_Name")
    private String Name;
    @Column(name = "Student_Contact")
    private int contactNo;


}
