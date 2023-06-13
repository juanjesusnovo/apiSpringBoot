package com.example.apispringboot.controllers;
import com.example.apispringboot.dto.UserCreateDTO;
import com.example.apispringboot.dto.UserDTO;
import com.example.apispringboot.models.User;
import com.example.apispringboot.repositories.UserRepository;
import com.example.apispringboot.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<UserDTO> result = new ArrayList<>();
        for (User user:userRepository.findAll()){
            result.add(new UserDTO(user));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(id.toString()));
        return new ResponseEntity<>(new UserDTO((user)), HttpStatus.OK);
    }
    @PostMapping("/users/create")
    public ResponseEntity<Object> create(@RequestBody UserCreateDTO userCreateDTO){
        User user = userRepository.save(new User(userCreateDTO));
        return new ResponseEntity<>(user, HttpStatus.OK);
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
