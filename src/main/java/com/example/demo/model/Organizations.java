package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "organizations")
public class Organizations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orgid", nullable = false, unique = true)
    private int orgid;  // Changed from int to Long

    @Column(name = "orgloc", nullable = false)
    private String orgloc;

    @Column(name = "orgname", nullable = false)
    private String orgname;

    // Constructors
    public Organizations() {
    }

    public Organizations(int orgid, String orgloc, String orgname) {  // Updated orgid type
        this.orgid = orgid;
        this.orgloc = orgloc;
        this.orgname = orgname;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrgid() {  // Updated return type
        return orgid;
    }

    public void setOrgid(int orgid) {  // Updated parameter type
        this.orgid = orgid;
    }

    public String getOrgloc() {
        return orgloc;
    }

    public void setOrgloc(String orgloc) {
        this.orgloc = orgloc;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }
}
