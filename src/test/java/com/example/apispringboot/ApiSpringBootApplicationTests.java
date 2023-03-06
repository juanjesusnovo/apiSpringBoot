package com.example.apispringboot;
import com.example.apispringboot.repositories.MessageRepository;
import com.example.apispringboot.repositories.RatingRepository;
import com.example.apispringboot.repositories.TattooerRepository;
import com.example.apispringboot.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApiSpringBootApplicationTests {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TattooerRepository tattooerRepository;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    RatingRepository ratingRepository;

    @Test
    void contextLoads() {
        assert userRepository.count() == 2;
        assert tattooerRepository.count() == 2;
        assert messageRepository.count() == 10;
        assert ratingRepository.count() == 10;
    }

    @Test
    void listTest() throws Exception {
        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("pepe"))
                .andExpect(jsonPath("$[0].surname").value("pepito"))
                .andExpect(jsonPath("$[0].username").value("xXpepeXx"))
                .andExpect(jsonPath("$[0].email").value("pepeusuario@gmail.com"));
    }

    @Test
    void creationTest() throws Exception {
        long usersCount = userRepository.count();
        String testUser = "{\"name\": \"trolo\", \"surname\": \"troloxx\", \"username\": \"troloxi\", \"email\": \"trolox@gmail.com\", \"password\": \"1234pass\" }";

        mockMvc.perform(post("/users/create").contentType(MediaType.APPLICATION_JSON).content(testUser))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("trolo"))
                .andExpect(jsonPath("$.surname").value("troloxx"))
                .andExpect(jsonPath("$.username").value("troloxi"))
                .andExpect(jsonPath("$.email").value("trolox@gmail.com"))
                .andExpect(jsonPath("$.password").value("1234pass"));
        assert userRepository.count() == usersCount + 1;
    }

    @Test
    void updateTest() throws Exception {
        String testUser = "{\"name\": \"trolo\", \"surname\": \"troloxx\", \"username\": \"troloxi\", \"email\": \"trolox@gmail.com\", \"password\": \"1234pass\" }";
        mockMvc.perform(put("/users/1").contentType(MediaType.APPLICATION_JSON).content(testUser))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("trolo"));
    }

}
