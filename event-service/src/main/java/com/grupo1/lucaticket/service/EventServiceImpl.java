package com.grupo1.lucaticket.service;


import com.grupo1.lucaticket.controller.EventController;
import com.grupo1.lucaticket.model.Event;
import com.grupo1.lucaticket.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventServiceImpl implements EventService {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventRepository repository;

    @Override
    public List<Event> findAll() {
        log.info("Antes de hacer la búsqueda");
        return repository.findAll();
    }

    @Override
    public void saveEvent(Event event) {

        repository.save(event);
    }

}
