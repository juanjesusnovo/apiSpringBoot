package com.example.apispringboot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Rating {
    @Id
    @GeneratedValue
    private Long id;

    private Integer rate;

    @ManyToOne
    @JoinColumn()
    private User user;

    public Rating(Integer rate, User user) {
        this.rate = rate;
        this.user = user;
    }
}
