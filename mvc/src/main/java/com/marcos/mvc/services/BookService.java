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

    public void createBook(Books b) {
        bookRepository.save(b);
    }

    public Books findBook(Long id) {
        Optional<Books> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }
    public void updateBook(Books book) {
        Optional<Books> existingBook = bookRepository.findById(book.getId());
        if (existingBook.isPresent()) {
            Books updatedBook = existingBook.get();
            updatedBook.setTitle(book.getTitle());
            updatedBook.setDescription(book.getDescription());
            updatedBook.setLanguage(book.getLanguage());
            updatedBook.setNumberOfPages(book.getNumberOfPages());

            bookRepository.save(updatedBook);
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

