package com.example.apispringboot.controllers;

import com.example.apispringboot.dto.LocationCreateDTO;
import com.example.apispringboot.models.Location;
import com.example.apispringboot.models.Tattooer;
import com.example.apispringboot.repositories.LocationRepository;
import com.example.apispringboot.repositories.TattooerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LocationController {
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    TattooerRepository tattooerRepository;

    @GetMapping("/location")
    public ResponseEntity<Object> index(){
        return new ResponseEntity<>(locationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        return new ResponseEntity<>(locationRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/location/create")
    public ResponseEntity<Object> create(@RequestBody LocationCreateDTO locationCreateDTO){
        Tattooer tattooer = tattooerRepository.findById(locationCreateDTO.getTattooer()).get();
        Location location = new Location(locationCreateDTO.getLat(), locationCreateDTO.getLng(), tattooer);
        locationRepository.save(location);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @DeleteMapping("/location/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<Location> oldLocation = locationRepository.findById(id);
        oldLocation.ifPresent(value -> locationRepository.delete(value));
        return new ResponseEntity<>(oldLocation.isPresent(), HttpStatus.OK);
    }

}
