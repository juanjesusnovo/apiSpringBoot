package com.example.apispringboot.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter
public class Tattooer {
    @Id
    @GeneratedValue
    private Long Id;

    private String name;
    private String email;
    private String password;

    @JsonManagedReference
    @OneToMany(mappedBy = "tattooer")
    private Set<User> tattooers = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "tattooer")
    private Set<Style> styles = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "tattooer")
    private Set<Location> locations = new HashSet<>();


    public Tattooer(){}

    public Tattooer(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
