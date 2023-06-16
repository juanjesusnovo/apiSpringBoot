package com.example.apispringboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
public class LocationCreateDTO implements Serializable {
    private Float lat;
    private Float lng;
    private Long tattooer;
}
