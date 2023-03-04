package com.example.apispringboot.controllers;
import com.example.apispringboot.models.Message;
import com.example.apispringboot.repositories.MessageRepository;
import com.example.apispringboot.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageService messageService;

    @GetMapping("/messages")
    public ResponseEntity<Object> index() {

        return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.OK);
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long Id) {
        return new ResponseEntity<>(messageService.getMessageById(Id), HttpStatus.OK);
    }

    @PostMapping("/messages/create")
    public ResponseEntity<Object> create(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.createMessage(message), HttpStatus.OK);
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long Id) {
        return new ResponseEntity<>(messageService.deleteMessage(Id), HttpStatus.OK);
    }

    @PutMapping("/messages/{id}")
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
