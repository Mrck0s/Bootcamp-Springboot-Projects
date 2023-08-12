package com.example.productos.services;

import com.example.productos.models.Categoria;
import com.example.productos.models.Productos;
import com.example.productos.repositories.ProductosRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosServicio {

    private final ProductosRepositorio productosRepositorio;

    public ProductosServicio(ProductosRepositorio productosRepositorio){
        this.productosRepositorio = productosRepositorio;
    }

    public Productos addProd(Productos p){
        return productosRepositorio.save(p);
    }

    public Productos encontrarPorId(Long id){
        Optional<Productos> optionalProductos = productosRepositorio.findById(id);
        if (optionalProductos.isPresent()){
            return optionalProductos.get();
        } else {
            return null;
        }
    }

    public List<Productos> todosLosProductos(){
        List<Productos> todosLosProductos = productosRepositorio.findAll();
            for(Productos productos : todosLosProductos){
               List <Categoria> categoria;
                categoria = productos.getCategorias();
                productos.setCategorias(categoria);
            }
            return productosRepositorio.findAll();
    }

}
