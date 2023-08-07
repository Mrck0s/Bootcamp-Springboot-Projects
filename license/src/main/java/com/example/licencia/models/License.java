package com.example.licencia.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "License")
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Date expirationDate;
    private String state;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persons_id")
    private Persons person;

    public License(){

    }

    public License(Long id, String number, Date expirationDate, String state){
        this.id = id;
        this.number = number;
        this.expirationDate = expirationDate;
        this.state = state;
    }

    public void setIdAndFormatNumber(Long id) {
        this.id = id;
        this.number = String.format("%06d", id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Persons getPerson() {
        return person;
    }

    public void setPerson(Persons person) {
        this.person = person;
    }
}
