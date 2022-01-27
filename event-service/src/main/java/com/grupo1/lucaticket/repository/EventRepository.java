package com.grupo1.lucaticket.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.grupo1.lucaticket.model.Event;


public interface EventRepository extends MongoRepository<Event, Integer> {
	
	@Query("{ 'genero' : ?0 }")
	List<Event> findByGenero(String genero);
}
