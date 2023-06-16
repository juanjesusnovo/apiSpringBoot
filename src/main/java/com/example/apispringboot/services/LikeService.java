package com.example.apispringboot.services;
import com.example.apispringboot.models.Like;
import com.example.apispringboot.repositories.LikeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class LikeService {

    @Autowired
    LikeRepository likeRepository;

    public List<Like> getAllRates(){

        return (List<Like>) likeRepository.findAll();
    }

    public Optional<Like> getRateById(Long Id){

        return likeRepository.findById(Id);
    }

    public Like createRate(Like newRate){
        likeRepository.save(newRate);
        return newRate;
    }

    public boolean deleteRate(Long rateId){
        Optional<Like> rate = likeRepository.findById(rateId);
        rate.ifPresent(value -> likeRepository.delete(value));
        return rate.isPresent();
    }
}
