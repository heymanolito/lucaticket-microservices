package com.grupo1.lucaticket.service;


import com.grupo1.lucaticket.model.Event;
import com.grupo1.lucaticket.model.Recinto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EventServiceTest {

    @Autowired
    EventService serviceTest;

    @BeforeEach
    void setUp() {
        serviceTest.deleteAll();
    }

    @DisplayName("Given un evento" +
            "When un evento es añadido" +
            "Then se suma 1 a la base de datos")
    @Test
    void shouldAddEntryToDatabase() {
        // Given
        Integer[] rangoPrecios = {10, 20};
        Recinto recinto = new Recinto(1L, "Sala pepe", "Badalona", "Calle Jaume", 4000);
        Event event = new Event(1, "La pantoja", "hola", "adios", "GDSGDS", LocalDate.now(), LocalTime.now(), rangoPrecios, "hola", recinto);
        //When
        serviceTest.saveEvent(event);
        int expected = 1;
        int actual = serviceTest.findAll().size();
        //Then
        assertThat(expected).isEqualTo(actual);
    }

}
