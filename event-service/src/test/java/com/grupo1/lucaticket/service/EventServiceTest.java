package com.grupo1.lucaticket.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grupo1.lucaticket.dto.EventResponse;
import com.grupo1.lucaticket.model.Event;
import com.grupo1.lucaticket.model.Recinto;

@SpringBootTest
public class EventServiceTest {

	@Autowired
	EventService serviceTest;

	@BeforeEach
	void setUp() {
		serviceTest.deleteAll();
	}

	@DisplayName("Given un evento" + "When un evento es añadido" + "Then se suma 1 a la base de datos")
	@Test
	void shouldAddEntryToDatabase() {
		// Given
		Integer[] rangoPrecios = { 10, 20 };
		Recinto recinto = new Recinto(1, "Sala pepe", "Badalona", "Calle Jaume", 4000);

		Event event = new Event(1, "La pantoja", "hola", "adios", "GDSGDS", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "hola", recinto, "Copla");

		// When
		serviceTest.saveEvent(event);
		int expected = 1;
		int actual = serviceTest.findAll().size();
		// Then
		assertThat(expected).isEqualTo(actual);
	}

	@DisplayName("Given dos eventos" + "When dos eventos con géneros son añadidos" + "Then tamaño lista de género X es igual a 1")
	@Test
	void shouldBeAnEventWithThisGenre() {
		// Given
		Integer[] rangoPrecios = { 10, 20 };
		Recinto recinto = new Recinto(1, "Sala pepe", "Badalona", "Calle Jaume", 4000);

		Event event = new Event(1, "La pantoja", "hola", "adios", "GDSGDS", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "hola", recinto, "Copla");

		Event event2 = new Event(1, "La pantoja", "hola", "adios", "GDSGDS", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "hola", recinto, "Reggeaton");
		// When
		serviceTest.saveEvent(event);
		serviceTest.saveEvent(event2);
		int expected = 1;
		List<EventResponse> lista = serviceTest.findByGenero(event.getGenero());
		
		/*for (int i = 0; i < lista.size(); i++) {
			if (event.getGenero()==lista.get(i).getGenero()) {
				
				cont +=1;
				System.out.println(lista.get(i).getGenero());		
			}
		}*/
		// Then
		assertThat(expected).isEqualTo(lista.size());
		

	}

}
