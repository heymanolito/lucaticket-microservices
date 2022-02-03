package com.grupo1.lucaticket.repository;

import com.grupo1.lucaticket.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface EventRepository extends MongoRepository<Event, Integer> {

    @Query("{ $text: { $search: \"?0\" } }")
    List<Event> findByNombre(String nombre);

    @Query("{ 'genero' : ?0 }")
    List<Event> findByGenero(String genero);

    @Query("{ 'recinto.ciudad' : ?0 }")
    List<Event> findByCity(String ciudad);

}
