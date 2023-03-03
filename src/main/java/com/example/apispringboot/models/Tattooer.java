package com.example.apispringboot.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Tattooer {
    @Id
    @GeneratedValue
    private Long Id;

    private String name;
    private String email;
    private String password;

    public Tattooer(){}

    public Tattooer(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
