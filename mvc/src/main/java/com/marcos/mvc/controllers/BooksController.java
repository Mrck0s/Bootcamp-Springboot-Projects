package com.marcos.mvc.controllers;

import com.marcos.mvc.models.Books;
import com.marcos.mvc.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String showBooks(Model model) {
        List<Books> books = bookService.allBooks();
        model.addAttribute("books", books);
        model.addAttribute("book", new Books());
        return "index";
    }
    @RequestMapping(value = "api/books/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
}

