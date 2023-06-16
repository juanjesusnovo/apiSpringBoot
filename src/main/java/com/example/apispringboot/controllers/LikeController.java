package com.example.apispringboot.controllers;
import com.example.apispringboot.models.Like;
import com.example.apispringboot.models.Tattooer;
import com.example.apispringboot.models.User;
import com.example.apispringboot.repositories.LikeRepository;
import com.example.apispringboot.repositories.TattooerRepository;
import com.example.apispringboot.repositories.UserRepository;
import com.example.apispringboot.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LikeController {
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    LikeService likeService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TattooerRepository tattooerRepository;

    @GetMapping("/likes")
    public ResponseEntity<Object> index() {

        return new ResponseEntity<>(likeService.getAllRates(), HttpStatus.OK);
    }

    @PostMapping("/likes/create")
    public ResponseEntity<Object> create(@RequestBody Like like) {
        return new ResponseEntity<>(likeService.createRate(like), HttpStatus.OK);
    }

    @DeleteMapping("/likes/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long Id) {
        return new ResponseEntity<>(likeService.deleteRate(Id), HttpStatus.OK);
    }

    @PutMapping("/likes/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long Id, @RequestBody Like like) {
        Optional<Like> oldRate = likeRepository.findById(Id);
        if(oldRate.isPresent()) {
            like.setId(Id);
            likeRepository.save(like);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/likeUser/{id}")
    public ResponseEntity<Object> index(@PathVariable("id") Long id){
        User user = userRepository.findById(id).get();
        return new ResponseEntity<>(likeRepository.findLikesByUserId(user.getId()), HttpStatus.OK);
    }

    @GetMapping("/likeTattooer/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        Tattooer tattooer = tattooerRepository.findById(id).get();
        return new ResponseEntity<>(likeRepository.findLikesByTattooerId(tattooer.getId()), HttpStatus.OK);
    }
}
