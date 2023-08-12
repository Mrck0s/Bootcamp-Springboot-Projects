package com.example.productos.repositories;

import com.example.productos.models.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepositorio extends CrudRepository<Categoria,Long> {

    List<Categoria> findAll();

}
