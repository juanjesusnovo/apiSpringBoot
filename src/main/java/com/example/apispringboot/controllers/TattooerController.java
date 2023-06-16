package com.example.apispringboot.controllers;
import com.example.apispringboot.dto.TattooerDTO;
import com.example.apispringboot.dto.TattooerImageCreateDTO;
import com.example.apispringboot.models.Image;
import com.example.apispringboot.models.Tattooer;
import com.example.apispringboot.models.TattooerImage;
import com.example.apispringboot.repositories.ImageTattooerRespository;
import com.example.apispringboot.repositories.ImagesRepository;
import com.example.apispringboot.repositories.TattooerRepository;
import com.example.apispringboot.services.ImageService;
import com.example.apispringboot.services.TattooerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TattooerController {
    @Autowired
    TattooerRepository tattooerRepository;
    @Autowired
    TattooerService tattooerService;
    @Autowired
    ImageService imageService;
    @Autowired
    ImagesRepository imagesRepository;
    @Autowired
    ImageTattooerRespository imageTattooerRespository;

    @GetMapping("/tattooers")
    public ResponseEntity<Object> index(){
        List<TattooerDTO> result = new ArrayList<>();
        for (Tattooer tattooer:tattooerRepository.findAll()){
            result.add(new TattooerDTO(tattooer));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/tattooers/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        Tattooer tattooer = tattooerRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(id.toString()));
        return new ResponseEntity<>(new TattooerDTO((tattooer)), HttpStatus.OK);
    }
    @GetMapping("/tattooersimg/{title}")
    public ResponseEntity<Object> index(@PathVariable("title")String title){
        List<Image> imagenes = imagesRepository.findImagesByTitle(title);
        return new ResponseEntity<>(imagenes, HttpStatus.OK);
    }
    @PostMapping("/tattooers/create")
    public ResponseEntity<Object> create(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("info") String info, @RequestParam("styles") String styles, @RequestParam("tfno") String tfno, @RequestParam("twitter") String twitter, @RequestParam("instagram") String instagram, @RequestParam("facebook") String facebook ,@RequestParam("picture") MultipartFile picture) throws IOException {
        String imagen = imageService.addImage(name, picture);
        Tattooer tattooer = tattooerRepository.save(new Tattooer(name, email, password, info, styles, tfno, twitter, instagram, facebook, imagen));
        return new ResponseEntity<>(tattooer, HttpStatus.OK);
    }
    @PostMapping("/tattooers/image")
    public ResponseEntity<Object> create(@RequestParam("id")Long id, @RequestParam("image") MultipartFile imagen) throws IOException{
        String img = imageService.addImage(id.toString(), imagen);
        Tattooer tattooer = tattooerRepository.findById(id).get();
        TattooerImage tattooerImage = imageTattooerRespository.save(new TattooerImage(tattooer, img));
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    @DeleteMapping("/tattooers/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(tattooerService.deleteTattooer(id), HttpStatus.OK);
    }
    @PutMapping("/tattooers/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Tattooer tattooer){
        Optional<Tattooer> oldTattooer = tattooerRepository.findById(id);
        if(oldTattooer.isPresent()){
            tattooer.setId(id);
            tattooerRepository.save(tattooer);
            return new ResponseEntity<>(tattooer, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
