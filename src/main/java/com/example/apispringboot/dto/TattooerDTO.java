package com.example.apispringboot.dto;

import com.example.apispringboot.models.Location;
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
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TattooerDTO implements Serializable {
    private Long Id;
    private String name;
    private String email;
    private String info;
    private String styles;
    private String tfno;
    private String twitter;
    private String instagram;
    private String facebook;
    private String picture;

    private List<String> images;
    private List<String> tattooers;
    private Set<Location> location;

    public TattooerDTO(Tattooer tattooer){
        this.Id = tattooer.getId();
        this.name = tattooer.getName();
        this.email = tattooer.getEmail();
        this.info = tattooer.getInfo();
        this.styles = tattooer.getStyles();
        this.tfno = tattooer.getTfno();
        this.twitter = tattooer.getTwitter();
        this.instagram = tattooer.getInstagram();
        this.facebook = tattooer.getFacebook();
        this.picture = tattooer.getPicture();
        this.images = new ArrayList<>();
        for(TattooerImage tattooerImage: tattooer.getImages()){
            images.add(String.valueOf(tattooerImage.getImage()));
        }
        this.tattooers = new ArrayList<>();
        for(User user: tattooer.getTattooers()){
            tattooers.add(String.valueOf(user.getId()));
        }
        this.location = tattooer.getLocations();

    }
}
