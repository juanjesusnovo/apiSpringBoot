package com.example.apispringboot.controllers;

import com.example.apispringboot.models.Image;
import com.example.apispringboot.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
public class ImageController {
    @Autowired
    ImageService imageService;

    @GetMapping("/images")
    public ResponseEntity<Object> index() {

        return new ResponseEntity<>(imageService.getAllImages(), HttpStatus.OK);
    }

    @GetMapping("/images/{id}")
    public String getImage(@PathVariable("id") String id){
        Image image = imageService.getImageById(id);
        return "<img src=\"data:image/jpeg;base64, " + Base64.getEncoder().encodeToString(image.getImage().getData()) + "\">";
    }

    @PostMapping("/images/add")
    public String addImage(@RequestParam("title") String title, @RequestParam("image") MultipartFile image) throws IOException {
        return imageService.addImage(title, image);
    }
}
