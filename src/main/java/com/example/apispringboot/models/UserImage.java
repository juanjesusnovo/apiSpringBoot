package com.example.apispringboot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@NoArgsConstructor
public class UserImage {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    @JoinColumn
    private User user;

    private String image;
}
