package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Hibernate annotation for automatic UUID generation
    private Integer id;

    @Column(name = "unitno", nullable = false)
    private String unitno;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "orgid", nullable = false)
    private Integer orgid;  // Changed from String to Integer

    // Default constructor
    public Team() {
    }

    // Parameterized constructor
    public Team(String unitno, String department, Integer orgid) {
        this.unitno = unitno;
        this.department = department;
        this.orgid = orgid;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getunitno() {
        return unitno;
    }

    public void setunitno(String unitno) {
        this.unitno = unitno;
    }

    public String getdepartment() {
        return department;
    }

    public void setdepartment(String department) {
        this.department = department;
    }

    public Integer getorgid() {
        return orgid;
    }

    public void setorgid(Integer orgid) {
        this.orgid = orgid;
    }
}
