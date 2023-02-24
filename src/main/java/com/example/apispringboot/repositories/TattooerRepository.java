package com.example.apispringboot.repositories;

import com.example.apispringboot.models.Tattooer;
import org.springframework.data.repository.CrudRepository;

public interface TattooerRepository extends CrudRepository<Tattooer, Long> {
}
