package com.marcos.mvc.controllers;

import com.marcos.mvc.models.Books;
import com.marcos.mvc.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksApi {
    private final BookService bookService;

    public BooksApi(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Books> index() {
        return bookService.allBooks();
    }

    @PostMapping
    public Books create(@RequestParam(value = "title") String title,
                        @RequestParam(value = "description") String desc,
                        @RequestParam(value = "language") String lang,
                        @RequestParam(value = "pages") Integer numOfPages) {
        Books book = new Books(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }

    @GetMapping("/{id}")
    public Books show(@PathVariable("id") Long id) {
        Books book = bookService.findBook(id);
        return book;
    }
}
