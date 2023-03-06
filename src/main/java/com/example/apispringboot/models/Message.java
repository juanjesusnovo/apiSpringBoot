package com.example.apispringboot.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue
    private Long Id;


    private String text;

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private User user;

    public Message(String text, User user) {
        this.text = text;
        this.user = user;
    }
}
