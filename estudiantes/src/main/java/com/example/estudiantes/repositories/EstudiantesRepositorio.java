package com.example.estudiantes.repositories;

import com.example.estudiantes.models.Estudiantes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudiantesRepositorio extends  CrudRepository<Estudiantes, Long> {

    List<Estudiantes> findAll();

}
