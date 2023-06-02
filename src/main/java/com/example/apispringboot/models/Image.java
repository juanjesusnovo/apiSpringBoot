package com.example.apispringboot.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "images")
@NoArgsConstructor @Getter @Setter
public class Image {

    @Id
    private String id;
    private String title;
    private Binary image;

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private User user;

    public Image(String title){
        this.title = title;
    }
}
