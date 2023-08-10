package com.example.estudiantes.services;

import com.example.estudiantes.models.Contacto;
import com.example.estudiantes.models.Estudiantes;
import com.example.estudiantes.repositories.ContactoRepositorio;
import com.example.estudiantes.repositories.EstudiantesRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudiantesServicio {

    private final EstudiantesRepositorio estudiantesRepositorio;
    private final ContactoRepositorio contactoRepositorio;

    public EstudiantesServicio(EstudiantesRepositorio estudiantesRepositorio, ContactoRepositorio contactoRepositorio){
        this.estudiantesRepositorio = estudiantesRepositorio;
        this.contactoRepositorio = contactoRepositorio;
    }

    public Estudiantes CrearEstudiante(Estudiantes e){
        return estudiantesRepositorio.save(e);
    }

    public List<Estudiantes> TodosLosEstudiantes(){
        return estudiantesRepositorio.findAll();
    }

    public Estudiantes buscarPorId(Long id){
        Optional<Estudiantes> todosLosEstudiantes = estudiantesRepositorio.findById(id);
        if(todosLosEstudiantes.isPresent()){
            return todosLosEstudiantes.get();
        }else{
            return null;
        }
    }

    public List<Estudiantes> TraerEstudiantes(){
        List<Estudiantes> todosLosEstudiantes = estudiantesRepositorio.findAll();
        for (Estudiantes estudiante : todosLosEstudiantes){
            Contacto contacto = contactoRepositorio.findContactoByEstudianteId(estudiante.getId());
            estudiante.setContacto(contacto);
        }
        return estudiantesRepositorio.findAll();
    }

}
