package com.example.demo.model;

import jakarta.persistence.*;
@Entity
@Table(name = "usersuploads")
public class useruploads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "indvid", nullable = false, unique = true)
    private int indvid;

    @Column(name = "imgname", nullable = true)
    private String imgname;

    @Column(name = "pdfname", nullable = true)
    private String pdfname;

    // Constructors
    public useruploads() {
    }

    public useruploads(int indvid, String imgname, String pdfname) {
        this.indvid = indvid;
        this.imgname = imgname;
        this.pdfname = pdfname;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getindvid() {
        return indvid;
    }

    public void setindvid(int indvid) {
        this.indvid = indvid;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getPdfname() {
        return pdfname;
    }

    public void setPdfname(String pdfname) {
        this.pdfname = pdfname;
    }
}
