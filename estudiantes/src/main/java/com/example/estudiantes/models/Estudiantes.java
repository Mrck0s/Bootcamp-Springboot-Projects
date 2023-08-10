package com.example.estudiantes.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Estudiantes")
public class Estudiantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String age;

    @OneToOne(mappedBy = "estudiantes", cascade = CascadeType.REMOVE)
    private Contacto contacto;

    public Estudiantes(){}

    public Estudiantes(Long id, String f, String l, String a){
        this.id = id;
        first_name = f;
        last_name = l;
        age = a;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
}
