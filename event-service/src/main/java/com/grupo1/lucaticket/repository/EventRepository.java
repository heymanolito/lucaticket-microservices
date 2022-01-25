package com.grupo1.lucaticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo1.lucaticket.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
