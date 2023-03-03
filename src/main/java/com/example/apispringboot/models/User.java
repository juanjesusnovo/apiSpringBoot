package com.example.apispringboot.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter
@Table(name = "usersCustom")
public class User {
    @Id
    @GeneratedValue
    private Long Id;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private Set<Message> messages = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private Set<Rating> rates = new HashSet<>();

    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;

    public User () {}

    public User (String name, String surname, String username, String email, String password){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
