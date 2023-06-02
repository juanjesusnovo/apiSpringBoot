package com.example.apispringboot.boot;
import com.example.apispringboot.factories.MessageFactory;
import com.example.apispringboot.factories.RatingFactory;
import com.example.apispringboot.models.Tattooer;
import com.example.apispringboot.models.User;
import com.example.apispringboot.repositories.MessageRepository;
import com.example.apispringboot.repositories.RatingRepository;
import com.example.apispringboot.repositories.TattooerRepository;
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
    TattooerRepository tattooerRepository;

    @Autowired
    MessageFactory messageFactory;
    @Autowired
    RatingFactory ratingFactory;

    @Override
    public void run(String... args) {
        User user1 = new User("pepe","pepito","xXpepeXx","pepeusuario@gmail.com","1234pass", false);
        User user2 = new User("manolo","manolito","donmanolops","manolo@gmail.com","1234pass", true);
        Tattooer tattooer1 = new Tattooer("dontattoo","dontattoo@gmail.com","1234pass");
        Tattooer tattooer2 = new Tattooer("pacoxtattoer","pacoxtattoer@gmail.com","1234pass");
        userRepository.save(user1);
        userRepository.save(user2);
        tattooerRepository.save(tattooer1);
        tattooerRepository.save(tattooer2);
        messageRepository.saveAll(messageFactory.get(10,user1));
        ratingRepository.saveAll(ratingFactory.get(10,user2));
    }
}
