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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EventServiceImpl implements EventService {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventAdapter eventAdapter;

    @Autowired
    EventRepository repository;

    @Override
    public List<EventResponse> findAll() {
        log.info("Hola que tal estas soy merche");
        return eventAdapter.of(repository.findAll());
    }

    @Override
    public Event saveEvent(Event event) {
        return repository.save(event);
    }

    @Override
    public Optional<Event> findById(int id) {
        log.info("Antes de encontrar el evento por id");
        return repository.findById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

}
