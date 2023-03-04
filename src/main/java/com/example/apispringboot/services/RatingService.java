package com.example.apispringboot.services;
import com.example.apispringboot.models.Rating;
import com.example.apispringboot.models.Tattooer;
import com.example.apispringboot.repositories.RatingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class RatingService {

    @Autowired
    RatingRepository ratingRepository;

    public List<Rating> getAllRates(){

        return (List<Rating>) ratingRepository.findAll();
    }

    public Optional<Rating> getRateById(Long Id){

        return ratingRepository.findById(Id);
    }

    public Rating createRate(Rating newRate){
        ratingRepository.save(newRate);
        return newRate;
    }

    public boolean deleteRate(Long rateId){
        Optional<Rating> rate = ratingRepository.findById(rateId);
        rate.ifPresent(value -> ratingRepository.delete(value));
        return rate.isPresent();
    }
}
