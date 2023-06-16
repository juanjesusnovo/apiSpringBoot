package com.example.apispringboot.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Book {
    @Id @GeneratedValue
    private Long id;

    private Boolean pending;
    private String date;

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private Tattooer tattooer;

    public Book(User user, Tattooer tattooer) {
        this.user = user;
        this.tattooer = tattooer;
        this.pending = true;
        this.date = "";
    }
}
