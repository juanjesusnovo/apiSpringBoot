package com.example.apispringboot.boot;
import com.example.apispringboot.factories.MessageFactory;
import com.example.apispringboot.factories.RatingFactory;
import com.example.apispringboot.models.User;
import com.example.apispringboot.repositories.MessageRepository;
import com.example.apispringboot.repositories.RatingRepository;
import com.example.apispringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageFactory messageFactory;
    @Autowired
    RatingFactory ratingFactory;

    @Override
    public void run(String... args) {
        List<User> users = userRepository.findAll();
        messageRepository.save(messageFactory.get(10,users));
        ratingRepository.save(ratingFactory.get(10,users));
    }
}
