package com.example.apispringboot.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter
@Table(name = "usersCustom")
public class User {
    @Id
    @GeneratedValue
    private Long Id;

    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;

    private Boolean isTattooer;

    @ManyToOne
    @JsonBackReference
    @JoinColumn()
    public Tattooer tattooer;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<Message> messages = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<Rating> rates = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<Image> images = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<Style> styles = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<Location> locations = new HashSet<>();

    public User () {}

    public User (String name, String surname, String username, String email, String password, Boolean isTattooer){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.isTattooer = isTattooer;
    }

}
