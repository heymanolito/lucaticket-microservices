package com.grupo1.lucaticket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo1.lucaticket.model.Event;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface EventRepository extends MongoRepository<Event, Integer> {
	
	@Query("{ $text: { $search: \"?0\" } }")
	List<Event> findByNombre(String nombre); 
	
}
