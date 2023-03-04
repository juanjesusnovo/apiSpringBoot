package com.example.apispringboot.services;
import com.example.apispringboot.models.Tattooer;
import com.example.apispringboot.repositories.TattooerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TattooerService {

    @Autowired
    TattooerRepository tattooerRepository;

    public List<Tattooer> getAllTattooers(){

        return (List<Tattooer>) tattooerRepository.findAll();
    }

    public Optional<Tattooer> getTattooerById(Long Id){

        return tattooerRepository.findById(Id);
    }

    public Tattooer createTattooer(Tattooer newTattoer){
        tattooerRepository.save(newTattoer);
        return newTattoer;
    }

    public boolean deleteTattooer(Long tattooerId){
        Optional<Tattooer> tattooer = tattooerRepository.findById(tattooerId);
        tattooer.ifPresent(value -> tattooerRepository.delete(value));
        return tattooer.isPresent();
    }

}
