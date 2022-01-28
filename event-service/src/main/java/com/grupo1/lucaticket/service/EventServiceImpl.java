package com.grupo1.lucaticket.service;


import com.grupo1.lucaticket.adapter.EventAdapter;
import com.grupo1.lucaticket.controller.EventController;
import com.grupo1.lucaticket.dto.EventResponse;
import com.grupo1.lucaticket.model.Event;
import com.grupo1.lucaticket.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EventServiceImpl implements EventService {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventAdapter eventAdapter;

    @Autowired
    SequenceGeneratedService IDGenerationService;

    @Autowired
    EventRepository repository;


    @Override
    public List<EventResponse> findAll() {
        log.info("--- Dentro del método findAll()");
        return eventAdapter.of(repository.findAll());
    }

    @Override
    public Event saveEvent(Event event) {
        event.setId(IDGenerationService.generateSequence(Event.SEQUENCE_NAME));
        return repository.save(event);
    }

    @Override
    public Optional<Event> findById(int id) {
        log.info("***** Antes de encontrar el evento por id");
        return repository.findById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
    
    @Override
    public List<EventResponse> findByNombre(String nombre){
    	log.info("Antes de encontrar el evento por nombre");
    	return eventAdapter.of(repository.findByNombre(nombre));
    }

	@Override
	public List<EventResponse> findByGenero(String genero) {
		log.info("******* Antes de filtrar por genero");
		return eventAdapter.of(repository.findByGenero(genero));
	}

	@Override
	public void delete(Event event) {
		repository.delete(event);
		
	}

}
