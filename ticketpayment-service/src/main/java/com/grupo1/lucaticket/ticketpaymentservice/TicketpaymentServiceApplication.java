package com.grupo1.lucaticket.ticketpaymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TicketpaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketpaymentServiceApplication.class, args);
    }

}
