package com.example.apispringboot.controllers;
import com.example.apispringboot.models.Rating;
import com.example.apispringboot.repositories.MessageRepository;
import com.example.apispringboot.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RatingController {
    @Autowired
    RatingRepository ratingRepository;

    @GetMapping("/rates")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>(ratingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/rates/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long Id) {
        return new ResponseEntity<>(ratingRepository.findById(Id), HttpStatus.OK);
    }

    @PostMapping("/rates/create")
    public ResponseEntity<Object> create(@RequestBody Rating rating) {
        ratingRepository.save(rating);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @DeleteMapping("/rates/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long Id) {
        Optional<Rating> rating  = ratingRepository.findById(Id);
        rating.ifPresent(value -> ratingRepository.delete(value));
        return new ResponseEntity<>(rating.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/rates/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long Id, @RequestBody Rating rating) {
        Optional<Rating> oldRate = ratingRepository.findById(Id);
        if(oldRate.isPresent()) {
            rating.setId(Id);
            ratingRepository.save(rating);
            return new ResponseEntity<>(rating, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
