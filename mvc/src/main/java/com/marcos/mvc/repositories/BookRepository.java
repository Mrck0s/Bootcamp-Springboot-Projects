package com.marcos.mvc.repositories;

import com.marcos.mvc.models.Books;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Books, Long> {
    List<Books> findAll();
    List<Books> findByDescriptionContaining(String search);
    Long countByTitleContaining(String search);
    Long deleteByTitleStartingWith(String search);
}
