package com.marcos.mvc.controllers;

import com.marcos.mvc.models.Books;
import com.marcos.mvc.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BooksController {
    private final BookRepository bookRepository;

    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String showBooks(Model model) {
        List<Books> books = bookRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("book", new Books());
        return "index";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Books book) {
        bookRepository.save(book);
        return "redirect:/";
    }
}
