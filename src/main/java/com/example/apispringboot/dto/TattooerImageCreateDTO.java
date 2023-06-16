package com.example.apispringboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class TattooerImageCreateDTO {
    private String image;
    private Long tattooer;
}
