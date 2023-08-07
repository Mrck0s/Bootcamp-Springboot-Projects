package com.example.licencia.repositories;

import com.example.licencia.models.Persons;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonsRepository extends CrudRepository<Persons, Long> {

    List<Persons> findAll();
}
