package com.example.apispringboot.repositories;

import com.example.apispringboot.models.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {
    List<Location> findLocationsByTattooerId(Long id);
}
