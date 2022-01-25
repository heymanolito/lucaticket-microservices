package com.grupo1.lucaticket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo1.lucaticket.model.Event;


public interface EventRepository extends MongoRepository<Event, Integer> {


}
