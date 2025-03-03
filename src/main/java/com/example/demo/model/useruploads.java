package com.example.demo.model;

import jakarta.persistence.*;
@Entity
@Table(name = "useruploads")
public class useruploads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "indvid", nullable = false, unique = true)
    private int indvId;

    @Lob
    @Column(name = "profile_image", columnDefinition = "LONGBLOB")
    private byte[] profileImage;

    @Lob
    @Column(name = "img_pdf", columnDefinition = "LONGBLOB")
    private byte[] imgPdf;

    // Constructors
    public useruploads() {
    }

    public useruploads(int indvId, byte[] profileImage, byte[] imgPdf) {
        this.indvId = indvId;
        this.profileImage = profileImage;
        this.imgPdf = imgPdf;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIndvId() {
        return indvId;
    }

    public void setIndvId(int indvId) {
        this.indvId = indvId;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public byte[] getImgPdf() {
        return imgPdf;
    }

    public void setImgPdf(byte[] imgPdf) {
        this.imgPdf = imgPdf;
    }
}
