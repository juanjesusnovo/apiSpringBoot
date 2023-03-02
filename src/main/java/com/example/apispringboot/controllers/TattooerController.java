package com.example.apispringboot.controllers;
import com.example.apispringboot.models.Tattooer;
import com.example.apispringboot.repositories.TattooerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TattooerController {
    @Autowired
    TattooerRepository tattooerRepository;

    @GetMapping("/tattooers")
    public ResponseEntity<Object> index(){

        return new ResponseEntity<>(tattooerRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/tattooers/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        return new ResponseEntity<>(tattooerRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping("/tattooers/create")
    public ResponseEntity<Object> create(@RequestBody Tattooer tattooer){
        tattooerRepository.save(tattooer);
        return new ResponseEntity<>(tattooer, HttpStatus.OK);
    }
    @DeleteMapping("/tattooers/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<Tattooer> tattooer = tattooerRepository.findById(id);
        tattooer.ifPresent(value -> tattooerRepository.delete(value));
        return new ResponseEntity<>(tattooer.isPresent(), HttpStatus.OK);
    }
    @PutMapping("/tattooers/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Tattooer tattooer){
        Optional<Tattooer> oldTattooer = tattooerRepository.findById(id);
        if(oldTattooer.isPresent()){
            tattooer.setId(id);
            tattooerRepository.save(tattooer);
            return new ResponseEntity<>(tattooer, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
