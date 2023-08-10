package com.example.estudiantes.repositories;

import com.example.estudiantes.models.Contacto;
import com.example.estudiantes.models.Estudiantes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepositorio extends CrudRepository<Contacto, Long> {

    List<Contacto> findAll();

    @Query("SELECT e.contacto FROM Estudiantes e WHERE e.id = :estudianteId")
    Contacto findContactoByEstudianteId(@Param("estudianteId") Long estudianteId);
}

