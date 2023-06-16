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
        Tattooer tattooer1 = new Tattooer("dontattoo","dontattoo@gmail.com","1234pass","Somos un equipo de tatuadores que nos encanta nuestro trabajo, tenemos un precio económico y nos encataría trabajar contigo", "Japones, Realista, Minimalism, NewSchool","674324213","@dontattoo", "@dontattoo", "@dontattoo", "648c2c532412ae3ef30d44eb");
        Tattooer tattooer2 = new Tattooer("pacoxtattoer","pacoxtattoer@gmail.com","1234pass","Somos un equipo de tatuadores que nos encanta nuestro trabajo, tenemos un precio económico y nos encataría trabajar contigo","Old School, Puntillismo, Tribales", "643211290","@pacoxtattooer","@pacoxtattooer","@pacoxtattooer", "648c2d5d2412ae3ef30d44ec");
        Tattooer tattooer3 = new Tattooer("mikotattoo","mikotattoo@gmail.com","1234pass","Somos un equipo de tatuadores que nos encanta nuestro trabajo, tenemos un precio económico y nos encataría trabajar contigo","Japones", "678234567","@mikotattoo","@mikotattoo","@mikotattoo_", "648c2d7a2412ae3ef30d44ed");
        Tattooer tattooer4 = new Tattooer("kabanetatuajes","kabanetatuajes@gmail.com","1234pass","Somos un equipo de tatuadores que nos encanta nuestro trabajo, tenemos un precio económico y nos encataría trabajar contigo","Old School, Tribales", "654432231","@kabanetatuajes_","@kabanetatuajes1","@kabanetatuajes", "648c2dab2412ae3ef30d44ee");
        Tattooer tattooer5 = new Tattooer("tatuajes_pol","tatuajes_pol@gmail.com","1234pass","Somos un equipo de tatuadores que nos encanta nuestro trabajo, tenemos un precio económico y nos encataría trabajar contigo","Old School, Puntillismo, Tribales, 3DTattoo", "666789908","@tatuajes_pol","@tatuajes_pol","@tatuajes_pol", "648c2de02412ae3ef30d44ef");
        Tattooer tattooer6 = new Tattooer("makinary_tattoo","makinary_tattoo@gmail.com","1234pass","Somos un equipo de tatuadores que nos encanta nuestro trabajo, tenemos un precio económico y nos encataría trabajar contigo","Old School, NewSchool", "654456654","@makinary_tattoo","@makinary_tattoo","@makinary_tattoo", "648c2e002412ae3ef30d44f0");
        userRepository.save(user1);
        tattooerRepository.save(tattooer1);
        tattooerRepository.save(tattooer2);
        tattooerRepository.save(tattooer3);
        tattooerRepository.save(tattooer4);
        tattooerRepository.save(tattooer5);
        tattooerRepository.save(tattooer6);
    }
}
