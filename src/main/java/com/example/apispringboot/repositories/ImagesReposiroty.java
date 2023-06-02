package com.example.apispringboot.repositories;

import com.example.apispringboot.models.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImagesReposiroty extends MongoRepository<Image, String> {
}
