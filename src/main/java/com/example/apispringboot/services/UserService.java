package com.example.apispringboot.services;
import com.example.apispringboot.models.User;
import com.example.apispringboot.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUserById(Long Id){
        return userRepository.findById(Id);
    }

    public User createUser(User newUser){
        userRepository.save(newUser);
        return newUser;
    }

    public boolean deleteUser(Long userId){
        Optional<User> user = userRepository.findById(userId);
        user.ifPresent(value -> userRepository.delete(value));
        return user.isPresent();
    }

    /*public User updateUser(Long id, User user){

    }*/
}
