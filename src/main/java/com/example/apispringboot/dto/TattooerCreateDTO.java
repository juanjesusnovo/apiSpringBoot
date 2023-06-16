package com.example.apispringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TattooerCreateDTO implements Serializable {
    private String name;
    private String email;
    private String password;
    private String info;
    private String styles;
    private String tfno;
    private String twitter;
    private String instagram;
    private String facebook;
    private String picture;
}
