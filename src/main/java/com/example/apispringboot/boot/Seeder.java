package com.example.apispringboot.boot;
import com.example.apispringboot.factories.MessageFactory;
import com.example.apispringboot.models.Tattooer;
import com.example.apispringboot.models.User;
import com.example.apispringboot.repositories.MessageRepository;
import com.example.apispringboot.repositories.LikeRepository;
import com.example.apispringboot.repositories.TattooerRepository;
import com.example.apispringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TattooerRepository tattooerRepository;

    @Autowired
    MessageFactory messageFactory;

    @Override
    public void run(String... args) {
        User user1 = new User("admin","admin","admin","admin@gmail.com","1234pass", false, "");
        Tattooer tattooer1 = new Tattooer("dontattoo","dontattoo@gmail.com","1234pass","Somos un equipo de tatuadores que nos encanta nuestro trabajo, tenemos un precio económico y nos encataría trabajar contigo", "Japones, Realista, Minimalism, NewSchool","674324213","@dontattoo", "@dontattoo", "@dontattoo", "");
        Tattooer tattooer2 = new Tattooer("pacoxtattoer","pacoxtattoer@gmail.com","1234pass","Somos un equipo de tatuadores que nos encanta nuestro trabajo, tenemos un precio económico y nos encataría trabajar contigo","Old School, Puntillismo, Tribales", "643211290","@pacoxtattooer","@pacoxtattooer","@pacoxtattooer", "");
        userRepository.save(user1);
        tattooerRepository.save(tattooer1);
        tattooerRepository.save(tattooer2);
    }
}
