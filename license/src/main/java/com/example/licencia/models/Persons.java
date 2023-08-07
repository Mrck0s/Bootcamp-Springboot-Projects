package com.example.licencia.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Persons")
public class Persons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;

    @Column(updatable = false)
    private String createdAt;
    private String updateAt;

    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private License License;

    public Persons() {

    }

    public Persons(Long id, String first_name, String last_name){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public com.example.licencia.models.License getLicense() {
        return License;
    }

    public void setLicense(com.example.licencia.models.License license) {
        License = license;
    }
}
