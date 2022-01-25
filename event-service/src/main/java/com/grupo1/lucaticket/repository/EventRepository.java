package com.grupo1.lucaticket.repository;

import com.grupo1.lucaticket.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, Long> {


}
