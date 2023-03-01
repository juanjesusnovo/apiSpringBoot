package com.example.apispringboot.repositories;

import com.example.apispringboot.models.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long> {
}
