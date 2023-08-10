package com.example.estudiantes.services;

import com.example.estudiantes.models.Contacto;
import com.example.estudiantes.repositories.ContactoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServicio {

    private final ContactoRepositorio contactoRepositorio;

    public ContactoServicio(ContactoRepositorio contactoRepositorio){
        this.contactoRepositorio = contactoRepositorio;
    }

    public Contacto CrearContacto(Contacto c){
        return contactoRepositorio.save(c);
    }

    public List<Contacto> TodosLosContactos(){
        return contactoRepositorio.findAll();
    }

}
