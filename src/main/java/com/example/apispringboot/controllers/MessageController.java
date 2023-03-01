package com.example.apispringboot.controllers;
import com.example.apispringboot.models.Message;
import com.example.apispringboot.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {
    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/rates")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>(messageRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/rates/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long Id) {
        return new ResponseEntity<>(messageRepository.findById(Id), HttpStatus.OK);
    }

    @PostMapping("/rates/create")
    public ResponseEntity<Object> create(@RequestBody Message message) {
        messageRepository.save(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/rates/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long Id) {
        Optional<Message> message  = messageRepository.findById(Id);
        message.ifPresent(value -> messageRepository.delete(value));
        return new ResponseEntity<>(message.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/rates/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long Id, @RequestBody Message message) {
        Optional<Message> oldMessage = messageRepository.findById(Id);
        if(oldMessage.isPresent()) {
            message.setId(Id);
            messageRepository.save(message);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
