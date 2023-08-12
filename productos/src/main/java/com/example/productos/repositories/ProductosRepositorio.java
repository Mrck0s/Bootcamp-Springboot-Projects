package com.example.productos.repositories;

import com.example.productos.models.Productos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepositorio extends CrudRepository<Productos,Long> {

    List<Productos> findAll();

}
