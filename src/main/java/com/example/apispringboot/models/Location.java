package com.example.apispringboot.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Location {
    @Id
    private Long id;

    private Integer lat;
    private Integer lng;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Tattooer tattooer;

    public Location(Long id, Integer lat, Integer lng, User user){
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.user = user;
    }
    public Location(Long id, Integer lat, Integer lng, Tattooer tattooer){
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.tattooer = tattooer;
    }
}
