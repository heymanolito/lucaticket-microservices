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
import java.util.NoSuchElementException;
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
        log.info("--- Dentro del mÃ©todo findAll()");
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
        Optional<Event> opt = repository.findById(id);
        if ( opt.isEmpty() ) {
            log.info("***** No se ha encontrado evento con ese id");
            throw new NoSuchElementException("No existe ningun evento con id: " + id);
        }
        return repository.findById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public List<EventResponse> findByNombre(String nombre) {
        log.info("Antes de encontrar el evento por nombre");
        List<Event> opt = repository.findByNombre(nombre);
        if ( opt.isEmpty() ) {
            log.info("***** No se ha encontrado evento con ese nombre");
            throw new NoSuchElementException("No existe ningun evento con nombre: " + nombre);
        }
        return eventAdapter.of(repository.findByNombre(nombre));
    }

    @Override
    public List<EventResponse> findByGenero(String genero) {
        log.info("******* Antes de filtrar por genero");
        List<Event> opt = repository.findByGenero(genero);
        if ( opt.isEmpty() ) {
            log.info("***** No se ha encontrado evento con ese genero");
            throw new NoSuchElementException("No existe ningun evento con genero: " + genero);
        }
        return eventAdapter.of(repository.findByGenero(genero));
    }

    @Override
    public List<EventResponse> findByCiudad(String ciudad) {
        log.info("********** Antes de filtrar por ciudad");
        List<Event> opt = repository.findByCity(ciudad);
        if ( opt.isEmpty() ) {
            log.info("********* No se ha encotrado evento con esta ciudad");
            throw new NoSuchElementException("No existe ningun evento en esta ciudad: " + ciudad);
        }
        return eventAdapter.of(repository.findByCity(ciudad));
    }

    @Override
    public void delete(Event event) {
        Optional<Event> opt = repository.findById(event.getId());
        if ( opt.isEmpty() ) {
            log.info("***** No se ha encontrado evento con ese id");
            throw new NoSuchElementException("No existe ningun evento con id: " + event.getId());
        }
        repository.delete(event);

    }

    @Override
    public void updateEvent(Event event) {
        repository.save(event);

    }


}
