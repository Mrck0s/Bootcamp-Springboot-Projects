package com.marcos.mvc.services;

import com.marcos.mvc.models.Books;
import com.marcos.mvc.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Books> allBooks() {
        return bookRepository.findAll();
    }

    public Books createBook(Books b) {
        return bookRepository.save(b);
    }

    public Books findBook(Long id) {
        Optional<Books> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }
    public Books updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
        // Buscar el libro por id
        Optional<Books> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Books book = optionalBook.get();
            book.setTitle(title);
            book.setDescription(desc);
            book.setLanguage(lang);
            book.setNumberOfPages(numOfPages);
            return bookRepository.save(book);
        } else {
            return null;
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

