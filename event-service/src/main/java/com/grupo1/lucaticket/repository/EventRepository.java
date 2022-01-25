package com.grupo1.lucaticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo1.lucaticket.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

}
