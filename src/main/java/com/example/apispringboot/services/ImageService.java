package com.example.apispringboot.services;

import com.example.apispringboot.models.Image;
import com.example.apispringboot.repositories.ImagesReposiroty;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImagesReposiroty imagesReposiroty;

    public String addImage(String title, MultipartFile file) throws IOException {
        Image image = new Image(title);
        image.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes())
        );
        image = imagesReposiroty.insert(image);
        return image.getId();
    }

    public List<Image> getAllImages() {
        return (List<Image>) imagesReposiroty.findAll();
    }

    public Image getImageById(String id) {
        return imagesReposiroty.findById(id).get();
    }

    public boolean deleteImage(String id) {
        Optional<Image> image = imagesReposiroty.findById(id);
        image.ifPresent(value -> imagesReposiroty.delete(value));
        return image.isPresent();
    }
}
