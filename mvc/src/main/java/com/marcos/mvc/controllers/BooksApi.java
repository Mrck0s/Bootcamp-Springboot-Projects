package com.marcos.mvc.controllers;

import com.marcos.mvc.models.Books;
import com.marcos.mvc.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public String create(@RequestParam(value = "title") String title,
                        @RequestParam(value = "description") String desc,
                        @RequestParam(value = "language") String lang,
                        @RequestParam(value = "pages") Integer numOfPages) {
        Books book = new Books(title, desc, lang, numOfPages);
        bookService.createBook(book);
        return "redirect:/";
    }


    @PostMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                        @RequestParam(value = "title") String title,
                        @RequestParam(value = "description") String desc,
                        @RequestParam(value = "language") String lang,
                        @RequestParam(value = "pages") Integer numOfPages) {
        Books book = bookService.findBook(id);

        if (book != null) {
            book.setTitle(title);
            book.setDescription(desc);
            book.setLanguage(lang);
            book.setNumberOfPages(numOfPages);
            bookService.updateBook(book);
            return "redirect:/";
        } else {
            return "";
        }
    }
    @DeleteMapping("/api/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
