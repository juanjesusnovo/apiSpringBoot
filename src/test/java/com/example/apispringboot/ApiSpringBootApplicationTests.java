package com.example.apispringboot;
import com.example.apispringboot.repositories.MessageRepository;
import com.example.apispringboot.repositories.RatingRepository;
import com.example.apispringboot.repositories.TattooerRepository;
import com.example.apispringboot.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
    void rootWhenUnauthenticatedThen401() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isUnauthorized());
    }

    private String token;
    @BeforeAll
    void getToken() throws Exception{
        MvcResult result=this.mockMvc.perform(post("/token").with(httpBasic("xXpepeXx","1234pass")))
                .andExpect(status().isOk())
                .andReturn();

        String jwt = result.getResponse().getContentAsString();
        this.token=jwt;
    }

    @Transactional
    @Test
    void contextLoads() {
        assert userRepository.count() == 2;
        assert tattooerRepository.count() == 2;
        assert messageRepository.count() == 10;
        assert ratingRepository.count() == 10;
    }

    @Transactional
    @Test
    void listTest() throws Exception {

        mockMvc.perform(get("/users").header("Authorization","Bearer "+token).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("pepe"))
                .andExpect(jsonPath("$[0].surname").value("pepito"))
                .andExpect(jsonPath("$[0].username").value("xXpepeXx"))
                .andExpect(jsonPath("$[0].email").value("pepeusuario@gmail.com"));
    }

    @Transactional
    @Test
    void creationTest() throws Exception {
        long usersCount = userRepository.count();
        String testUser = "{\"name\": \"trolo\", \"surname\": \"troloxx\", \"username\": \"troloxi\", \"email\": \"trolox@gmail.com\", \"password\": \"1234pass\" }";

        mockMvc.perform(post("/users/create").header("Authorization","Bearer "+token).contentType(MediaType.APPLICATION_JSON).content(testUser))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("trolo"))
                .andExpect(jsonPath("$.surname").value("troloxx"))
                .andExpect(jsonPath("$.username").value("troloxi"))
                .andExpect(jsonPath("$.email").value("trolox@gmail.com"))
                .andExpect(jsonPath("$.password").value("1234pass"));
        assert userRepository.count() == usersCount + 1;
    }

    @Transactional
    @Test
    void updateTest() throws Exception {
        String testUser = "{\"name\": \"trolo\", \"surname\": \"troloxx\", \"username\": \"troloxi\", \"email\": \"trolox@gmail.com\", \"password\": \"1234pass\" }";
        mockMvc.perform(put("/users/1").header("Authorization","Bearer "+token).contentType(MediaType.APPLICATION_JSON).content(testUser))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("trolo"));
    }

}
