package com.example.apispringboot.repositories;

import com.example.apispringboot.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
