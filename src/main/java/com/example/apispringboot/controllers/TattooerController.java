package com.example.apispringboot.controllers;
import com.example.apispringboot.models.Tattooer;
import com.example.apispringboot.repositories.TattooerRepository;
import com.example.apispringboot.services.TattooerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TattooerController {
    @Autowired
    TattooerRepository tattooerRepository;
    @Autowired
    TattooerService tattooerService;

    @GetMapping("/tattooers")
    public ResponseEntity<Object> index(){

        return new ResponseEntity<>(tattooerService.getAllTattooers(), HttpStatus.OK);
    }
    @GetMapping("/tattooers/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        return new ResponseEntity<>(tattooerService.getTattooerById(id), HttpStatus.OK);
    }
    @PostMapping("/tattooers/create")
    public ResponseEntity<Object> create(@RequestBody Tattooer tattooer){
        return new ResponseEntity<>(tattooerService.createTattooer(tattooer), HttpStatus.OK);
    }
    @DeleteMapping("/tattooers/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(tattooerService.deleteTattooer(id), HttpStatus.OK);
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
