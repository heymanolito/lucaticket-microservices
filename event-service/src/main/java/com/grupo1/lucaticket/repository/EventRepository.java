package com.grupo1.lucaticket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo1.lucaticket.model.Event;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface EventRepository extends MongoRepository<Event, Integer> {
}
