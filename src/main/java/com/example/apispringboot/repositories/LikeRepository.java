package com.example.apispringboot.repositories;

import com.example.apispringboot.models.Like;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like, Long> {
    List<Like> findLikesByUserId(Long id);

    List<Like> findLikesByTattooerId(Long id);
}
