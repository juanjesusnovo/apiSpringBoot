package com.example.apispringboot.repositories;

import com.example.apispringboot.models.TattooerImage;
import org.springframework.data.repository.CrudRepository;

public interface ImageTattooerRespository extends CrudRepository<TattooerImage, Long> {
}
