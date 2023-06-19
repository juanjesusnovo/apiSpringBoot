package com.example.apispringboot.dto;

import com.example.apispringboot.models.Image;
import com.example.apispringboot.models.User;
import com.example.apispringboot.models.UserImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Long Id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private Boolean isTattooer;
    private Long tattooerId;
    private String picture;

    private List<String> images;

    public UserDTO(User user){
        this.Id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.isTattooer = user.getIsTattooer();
        this.images = new ArrayList<>();
        for (UserImage image: user.getImages()){
            images.add(String.valueOf(image.getImage()));
        }
        this.picture = user.getPicture();
        this.tattooerId = user.getTattoerId();
    }
}
