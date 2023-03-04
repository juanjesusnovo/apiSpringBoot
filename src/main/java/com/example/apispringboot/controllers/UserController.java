package com.example.apispringboot.controllers;
import com.example.apispringboot.models.User;
import com.example.apispringboot.repositories.UserRepository;
import com.example.apispringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
    @PostMapping("/users/create")
    public ResponseEntity<Object> create(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody User user){
        Optional<User> oldUser = userRepository.findById(id);
        if(oldUser.isPresent()){
            user.setId(id);
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
