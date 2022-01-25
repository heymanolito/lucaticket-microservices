package com.grupo1.lucaticket;


import com.grupo1.lucaticket.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class EventServiceApplication {

    @Autowired
    EventRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(EventServiceApplication.class, args);
    }


}
