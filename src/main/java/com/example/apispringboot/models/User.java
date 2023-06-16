package com.example.apispringboot.models;
import com.example.apispringboot.dto.UserCreateDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
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
    private String picture;
    private Long tattoerId;

    private Boolean isUser;
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
    private Set<Like> rates = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<UserImage> images = new HashSet<>();

   /* @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<Style> styles = new HashSet<>();*/

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<Location> locations = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<Book> books = new HashSet<>();

    public User () {}

    public User (String name, String surname, String username, String email, String password, Boolean isTattooer, String picture){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.isTattooer = isTattooer;
        this.picture = picture;
        this.isUser = true;
    }
    public User(String name, String password, Boolean isTattooer, Long tattoerId){
        this.name = name;
        this.password = password;
        this.isTattooer = isTattooer;
        this.tattoerId = tattoerId;
    }
    public User(UserCreateDTO userCreateDTO){
        this.name = userCreateDTO.getName();
        this.surname = userCreateDTO.getSurname();
        this.username = userCreateDTO.getUsername();
        this.email = userCreateDTO.getEmail();
        this.password = userCreateDTO.getPassword();
        this.isTattooer = userCreateDTO.getIsTattooer();
        this.picture = userCreateDTO.getPicture();
    }
}
