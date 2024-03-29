package com.example.apispringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.Binary;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO implements Serializable {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String picture;

    private Boolean isTattooer;
}
