package com.example.apispringboot.services;
import com.example.apispringboot.models.Message;
import com.example.apispringboot.models.Rating;
import com.example.apispringboot.repositories.MessageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<Message> getAllMessages(){

        return (List<Message>) messageRepository.findAll();
    }

    public Optional<Message> getMessageById(Long Id){

        return messageRepository.findById(Id);
    }

    public Message createMessage(Message newMessage){

        return messageRepository.save(newMessage);
    }

    public boolean deleteRate(Long rateId){
        Optional<Message> message = messageRepository.findById(rateId);
        message.ifPresent(value -> messageRepository.delete(value));
        return message.isPresent();
    }
}
