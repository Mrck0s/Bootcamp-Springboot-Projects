package com.example.productos.services;

import com.example.productos.models.Categoria;
import com.example.productos.models.Productos;
import com.example.productos.repositories.CategoriaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio {

    private final CategoriaRepositorio categoriaRepositorio;

    public CategoriaServicio(CategoriaRepositorio categoriaRepositorio){
        this.categoriaRepositorio = categoriaRepositorio;
    }

    public Categoria addCat(Categoria c){
        return categoriaRepositorio.save(c);
    }

    public Categoria encontrarPorId(Long id){
        Optional<Categoria> optionalCategoria = categoriaRepositorio.findById(id);
        if (optionalCategoria.isPresent()){
            return optionalCategoria.get();
        } else {
            return null;
        }
    }


    public List<Categoria> allCat(){
        List<Categoria> todasLasCategorias = categoriaRepositorio.findAll();
        for(Categoria categoria : todasLasCategorias){
            List <Productos> productos;
            productos = categoria.getProductos();
            categoria.setProductos(productos);
        }
        return categoriaRepositorio.findAll();
    }

}
