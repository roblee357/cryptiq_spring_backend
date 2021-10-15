package com.example.messagingstompwebsocket.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.messagingstompwebsocket.model.Message;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {

}