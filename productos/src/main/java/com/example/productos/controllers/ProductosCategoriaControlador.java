package com.example.productos.controllers;

import com.example.productos.models.Categoria;
import com.example.productos.models.Productos;
import com.example.productos.services.CategoriaServicio;
import com.example.productos.services.ProductosServicio;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductosCategoriaControlador {

    private final CategoriaServicio categoriaServicio;
    private final ProductosServicio productosServicio;

    public ProductosCategoriaControlador(CategoriaServicio categoriaServicio,
                                         ProductosServicio productosServicio){
        this.categoriaServicio = categoriaServicio;
        this.productosServicio = productosServicio;
    }

    @GetMapping("/")
    public String index(Model model){

        List<Productos> listaProductos = productosServicio.todosLosProductos();
        List<Categoria> listaCategorias = categoriaServicio.allCat();

        model.addAttribute("listaProductos", listaProductos);
        model.addAttribute("listaCategorias", listaCategorias);

        return "index";
    }




    @GetMapping("/products/new")
    public String productsNew(Model model){
        model.addAttribute("nuevoProducto", new Productos());
        List<Categoria> todasLasCategorias = categoriaServicio.allCat();
        model.addAttribute("todasLasCategorias", todasLasCategorias);
        return "productsNew";
    }

    @PostMapping("/products/new")
    public String createProduct(@Valid @ModelAttribute("nuevoProducto") Productos nuevoProducto, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/";
        } else {
            productosServicio.addProd(nuevoProducto);
        }
        return "redirect:/";
    }




    @GetMapping("/categories/new")
    public String categoriesNew(Model model){
        model.addAttribute("nuevaCategoria", new Categoria());
        List<Productos> todosLosProductos = productosServicio.todosLosProductos();
        model.addAttribute("todosLosProductos", todosLosProductos);
        return "categoryNew";
    }

    @PostMapping("/categories/new")
    public String createCategory(@Valid @ModelAttribute("nuevaCategoria") Categoria nuevaCategoria, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/";
        } else {
            categoriaServicio.addCat(nuevaCategoria);
        }
        return "redirect:/";
    }



    @GetMapping("/products/{id}")
    public String showProducts(@PathVariable("id") Long id, Model model){
        Productos productos = productosServicio.encontrarPorId(id);
        model.addAttribute("productos", productos);
        List<Categoria> todasLasCategorias = categoriaServicio.allCat();
        model.addAttribute("todasLasCategorias", todasLasCategorias);
        return "showProducts";
    }

    @PostMapping("/products/{id}")
    public String agregarCategoria(@PathVariable("id") Long id,
                                   @RequestParam("categoriaId") Long categoriaId){
        Productos productos = productosServicio.encontrarPorId(id);
        Categoria categoria = categoriaServicio.encontrarPorId(categoriaId);

        if (!productos.getCategorias().contains(categoria)) {
            productos.getCategorias().add(categoria);
            productosServicio.addProd(productos);
        }
        return "redirect:/products/" + id;
    }




    @GetMapping("/categories/{id}")
    public String showCategories(@PathVariable("id") Long id, Model model){
        Categoria categoria = categoriaServicio.encontrarPorId(id);
        model.addAttribute("categoria", categoria);
        List<Productos> todosLosProductos = productosServicio.todosLosProductos();
        model.addAttribute("todosLosProductos", todosLosProductos);
        return "showCategories";
    }

    @PostMapping("/categories/{id}")
    public String agregarProducto(@PathVariable("id") Long id, @RequestParam ("productoId") Long productoId){
        Categoria categoria = categoriaServicio.encontrarPorId(id);
        Productos productos = productosServicio.encontrarPorId(productoId);

        if (!categoria.getProductos().contains(productos)) {
            categoria.getProductos().add(productos);
            categoriaServicio.addCat(categoria);
        }
        return "redirect:/categories/" + id;
    }

}
