package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "userspersonals")
public class UserPersonals {  // Renamed class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "indvid", nullable = false, unique = true)
    private int indvid;  // Changed from int to Long

    @Column(name = "orgid", nullable = false, unique = true)
    private int orgid;  // Changed from int to Long


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "contactno", nullable = false)
    private long contactno;

    @Column(name = "email", nullable = false)
    private String email;

    // Constructors
    public UserPersonals() {
    }

    public UserPersonals(int indvid, int orgid, String name, int age, String gender, long contactno, String email) {
        this.indvid = indvid;
        this.orgid = orgid;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactno = contactno;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIndvid() {  // Updated return type
        return indvid;
    }

    public void setIndvid(int indvid) {  // Updated parameter type
        this.indvid = indvid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getContactno() {
        return contactno;
    }

    public void setContactno(long contactno) {
        this.contactno = contactno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getorgid() {
        return orgid;
    }

    public void setorgid(int orgid) {
        this.orgid = orgid;
    }
}
