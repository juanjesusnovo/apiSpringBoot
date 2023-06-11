package com.example.apispringboot.dto;

import com.example.apispringboot.models.Tattooer;
import com.example.apispringboot.models.TattooerImage;
import com.example.apispringboot.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TattooerDTO implements Serializable {
    private Long Id;
    private String name;
    private String email;
    private String password;

    private List<String> images;
    private List<String> tattooers;

    public TattooerDTO(Tattooer tattooer){
        this.Id = tattooer.getId();
        this.name = tattooer.getName();
        this.email = tattooer.getEmail();
        this.password = tattooer.getPassword();
        this.images = new ArrayList<>();
        for(TattooerImage tattooerImage: tattooer.getImages()){
            images.add(String.valueOf(tattooerImage.getId()));
        }
        this.tattooers = new ArrayList<>();
        for(User user: tattooer.getTattooers()){
            tattooers.add(String.valueOf(user.getId()));
        }
    }
}
