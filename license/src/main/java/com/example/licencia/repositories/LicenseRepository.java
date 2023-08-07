package com.example.licencia.repositories;

import com.example.licencia.models.License;
import com.example.licencia.models.Persons;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License,Long> {

    List<License> findAll();

    @Query("SELECT MAX(l.id) FROM License l")
    Long findMaxId();

    @Query("SELECT l FROM License l WHERE l.person = :person")
    License findByPerson(@Param("person") Persons person);

}
