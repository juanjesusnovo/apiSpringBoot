package com.example.apispringboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
public class BookCreateDTO implements Serializable {
    private Long user;
    private Long tattooer;
}
