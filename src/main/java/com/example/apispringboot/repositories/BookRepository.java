package com.example.apispringboot.repositories;

import com.example.apispringboot.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findBooksByUserId(Long id);
    List<Book> findBooksByTattooerId(Long id);
}
