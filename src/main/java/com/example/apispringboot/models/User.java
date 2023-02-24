package com.example.apispringboot.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

    public User () {}

    public User (Long Id, String name, String surname, String username, String email, String password){
        this.Id = Id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
