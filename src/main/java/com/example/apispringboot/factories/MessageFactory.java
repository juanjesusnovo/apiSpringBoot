package com.example.apispringboot.factories;
import com.example.apispringboot.models.User;
import org.aspectj.bridge.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/*@Component
public class MessageFactory {
    Faker esFaker = new Faker(new Locale("es-ES"));
    Random rand  = new Random();

    public List<Message> get(int number, List<User> users) {
        return IntStream.range(0,number)
                .mapToObj(x -> new Message(esFaker))
                .collect(Collectors.toList());
    }
}*/

