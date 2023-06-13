package com.example.apispringboot.models;
import com.example.apispringboot.dto.TattooerCreateDTO;
import com.example.apispringboot.dto.TattooerDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    private String info;
    private String styles;
    private String tfno;
    private String twitter;
    private String instagram;
    private String facebook;

    @JsonManagedReference
    @OneToMany(mappedBy = "tattooer")
    private Set<User> tattooers = new HashSet<>();

    /*@JsonManagedReference
    @OneToMany(mappedBy = "tattooer")
    private Set<Style> styles = new HashSet<>();*/

    @JsonManagedReference
    @OneToMany(mappedBy = "tattooer")
    private Set<Location> locations = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "tattooer")
    private Set<TattooerImage> images = new HashSet<>();


    public Tattooer(){}

    public Tattooer(String name, String email, String password, String info, String styles, String tfno, String twitter, String instagram, String facebook){
        this.name = name;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.info = info;
        this.styles = styles;
        this.tfno = tfno;
        this.twitter = twitter;
        this.instagram = instagram;
        this.facebook = facebook;
    }

    public Tattooer(TattooerCreateDTO tattooerCreateDTO){
        this.name = tattooerCreateDTO.getName();
        this.email = tattooerCreateDTO.getEmail();
        this.password = tattooerCreateDTO.getPassword();
        this.info = tattooerCreateDTO.getInfo();
        this.styles = tattooerCreateDTO.getStyles();
        this.tfno = tattooerCreateDTO.getTfno();
        this.twitter = tattooerCreateDTO.getTwitter();
        this.instagram = tattooerCreateDTO.getInstagram();
        this.facebook = tattooerCreateDTO.getFacebook();
    }
}
