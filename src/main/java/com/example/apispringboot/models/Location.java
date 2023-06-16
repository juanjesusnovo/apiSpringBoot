package com.example.apispringboot.models;

import com.example.apispringboot.dto.LocationCreateDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue
    private Long id;

    private Float lat;
    private Float lng;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Tattooer tattooer;

    public Location(Float lat, Float lng, User user){
        this.lat = lat;
        this.lng = lng;
        this.user = user;
    }
    public Location(Float lat, Float lng, Tattooer tattooer){
        this.lat = lat;
        this.lng = lng;
        this.tattooer = tattooer;
    }
}
