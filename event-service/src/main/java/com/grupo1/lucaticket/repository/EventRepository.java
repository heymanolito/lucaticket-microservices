package com.grupo1.lucaticket.repository;

<<<<<<< HEAD
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo1.lucaticket.model.Event;
import com.grupo1.lucaticket.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
=======
import com.grupo1.lucaticket.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, Long> {
>>>>>>> dev

public interface EventRepository extends MongoRepository<Event, Long> {

	
}
