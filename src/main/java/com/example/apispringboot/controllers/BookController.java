package com.example.apispringboot.controllers;

import com.example.apispringboot.dto.BookCreateDTO;
import com.example.apispringboot.models.Book;
import com.example.apispringboot.models.Tattooer;
import com.example.apispringboot.models.User;
import com.example.apispringboot.repositories.BookRepository;
import com.example.apispringboot.repositories.TattooerRepository;
import com.example.apispringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TattooerRepository tattooerRepository;

    @PostMapping("/book")
    public ResponseEntity<Object> create(@RequestBody BookCreateDTO book ) {
        // search for user
        User user = userRepository.findById(book.getUser()).get();
        // search for tattooer
        Tattooer tattooer = tattooerRepository.findById(book.getTattooer()).get();

        Book newBook = new Book(user, tattooer);
        bookRepository.save(newBook);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/createBook")
    public ResponseEntity<Object> create(@RequestBody Book book){
        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/bookUser/{id}")
    public ResponseEntity<Object> index(@PathVariable("id") Long id){
        User user = userRepository.findById(id).get();
        return new ResponseEntity<>(bookRepository.findBooksByUserId(user.getId()), HttpStatus.OK);
    }

    @GetMapping("/bookTattooer/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        Tattooer tattooer = tattooerRepository.findById(id).get();
        return new ResponseEntity<>(bookRepository.findBooksByTattooerId(tattooer.getId()), HttpStatus.OK);
    }
}
