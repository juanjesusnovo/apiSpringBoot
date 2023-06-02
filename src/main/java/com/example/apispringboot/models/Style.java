package com.example.apispringboot.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@NoArgsConstructor
public class Style {
    @Id
    private String id;
    private String style;

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private Tattooer tattooer;

    public Style(String style, User user){
        this.style = style;
        this.user = user;
    }

    public Style(String style, Tattooer tattooer){
        this.style = style;
        this.tattooer = tattooer;
    }
}
