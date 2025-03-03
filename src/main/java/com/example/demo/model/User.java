package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = true)
    private String name;
    @Column(nullable = true)
    private String unitno;
    @Column(nullable = true)
    private String department;
    @Column(nullable = true)
    private String orgname;
    @Column(nullable = true)
    private Integer indvid;
    @Column(nullable = true)
    private Integer orgid;

    public User() {}

    public User(String name, String unitno ,String department , String orgname , Integer indvid , Integer orgid) {
        this.name = name;
        this.unitno = unitno;
        this.department=department;
        this.orgname=orgname;
        this.indvid = indvid;
        this.orgid = orgid;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getunitno() { return unitno; }
    public void setunitno(String unitno) { this.unitno = unitno; }
    public String getdepartment() { return department; }
    public void setdepartment(String department) { this.department = department; }
    public String getorgname() { return orgname; }
    public void setorgname(String orgname) { this.orgname = orgname; }
    public void setindvid(Integer indvid){this.indvid=indvid;}
    public Integer getindvid(){return indvid;}
    public void setorgid(Integer orgid){this.orgid=orgid;}
    public Integer getorgid(){return orgid;}


}
