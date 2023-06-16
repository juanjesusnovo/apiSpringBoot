package com.example.apispringboot.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@NoArgsConstructor
@Table(name="likeCustom")
public class Like {
    @Id
    @GeneratedValue
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private Tattooer tattooer;

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private User user;

    public Like(User user, Tattooer tattooer) {
        this.user = user;
        this.tattooer = tattooer;
    }
}
