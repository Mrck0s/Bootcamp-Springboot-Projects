package com.marcos.mvc.repositories;

import com.marcos.mvc.models.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Books, Long> {
    List<Books> findAll();

}
