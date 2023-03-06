package com.example.apispringboot.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue
    private Long id;

    private Integer rate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private User user;

    public Rating(Integer rate, User user) {
        this.rate = rate;
        this.user = user;
    }
}
