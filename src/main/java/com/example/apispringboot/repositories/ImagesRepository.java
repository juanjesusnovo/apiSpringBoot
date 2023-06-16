package com.example.apispringboot.repositories;

import com.example.apispringboot.models.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ImagesRepository extends MongoRepository<Image, String> {
    List<Image> findImagesByTitle(String title);
}
