package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.dto.EventResponse;
import com.grupo1.lucaticket.model.Event;
import com.grupo1.lucaticket.model.Recinto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
		Recinto recinto = new Recinto(1, "Sala Apolo", "Madrid", "Calle Alcalá", 4000);

		Event event = new Event(1, "Isabel Pantoja", "Concierto de Isabel Pantoja",
				"Concierto por el aniverarsio de la carrera de Isabel Pantoja", "", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "Se tendrá que presentar prueba PCR de 2 días máximo de antelación y certificado COVID",
				recinto, "Copla");

		// When
		serviceTest.saveEvent(event);
		int expected = 1;
		int actual = serviceTest.findAll().size();
		// Then
		assertThat(expected).isEqualTo(actual);
	}

	@DisplayName("Given dos eventos" + "When dos eventos con géneros son añadidos"
			+ "Then tamaño lista de género X es igual a 1")
	@Test
	void shouldBeAnEventWithThisGenre() {
		// Given
		Integer[] rangoPrecios = { 10, 20 };
		Recinto recinto = new Recinto(1, "Sala Apolo", "Madrid", "Calle Alcalá", 4000);

		Event event = new Event(1, "Isabel Pantoja", "Concierto de Isabel Pantoja",
				"Concierto por el aniverarsio de la carrera de Isabel Pantoja", "", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "Se tendrá que presentar prueba PCR de 2 días máximo de antelación y certificado COVID",
				recinto, "Copla");

		Event event2 = new Event(1, "Isabel Pantoja", "Concierto de Isabel Pantoja",
				"Concierto por el aniverarsio de la carrera de Isabel Pantoja", "", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "Se tendrá que presentar prueba PCR de 2 días máximo de antelación y certificado COVID",
				recinto, "Punk");
		// When
		serviceTest.saveEvent(event);
		serviceTest.saveEvent(event2);
		int expected = 1;
		List<EventResponse> lista = serviceTest.findByGenero(event.getGenero());

		// Then
		assertThat(expected).isEqualTo(lista.size());

	}

	@Test
	void shouldBeAnEventInThisCity() {
		// Given
		Integer[] rangoPrecios = { 10, 20 };
		Recinto recinto = new Recinto(1, "Sala Apolo", "Madrid", "Calle Alcalá", 4000);

		Event event = new Event(1, "Isabel Pantoja", "Concierto de Isabel Pantoja",
				"Concierto por el aniverarsio de la carrera de Isabel Pantoja", "", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "Se tendrá que presentar prueba PCR de 2 días máximo de antelación y certificado COVID",
				recinto, "Copla");

		Recinto recinto2 = new Recinto(2, "Sala Apolo", "Badalona", "Calle Alcalá", 4000);

		Event event2 = new Event(2, "Isa Pantoja", "Concierto de Isa Pantoja",
				"Concierto por el aniverarsio de la carrera de Isa Pantoja", "", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "Se tendrá que presentar prueba PCR de 2 días máximo de antelación y certificado COVID",
				recinto2, "Copla");

		// When
		serviceTest.saveEvent(event2);
		serviceTest.saveEvent(event);
		int expected = 1;
		List<EventResponse> lista = serviceTest.findByCiudad("Madrid");

		// Then
		System.out.println(lista.get(0).getCiudadRecinto());
		assertThat(expected).isEqualTo(lista.size());
	}

	void shouldBeAnEventWithThisName() {
		// Given
		Integer[] rangoPrecios = { 10, 20 };
		Recinto recinto = new Recinto(1, "Sala Apolo", "Madrid", "Calle Alcalá", 4000);

		Event event = new Event(1, "Isabel Pantoja", "Concierto de Isabel Pantoja",
				"Concierto por el aniverarsio de la carrera de Isabel Pantoja", "", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "Se tendrá que presentar prueba PCR de 2 días máximo de antelación y certificado COVID",
				recinto, "Copla");

		Event event2 = new Event(2, "Isa Pantoja", "Concierto de Isa Pantoja",
				"Concierto por el aniverarsio de la carrera de Isa Pantoja", "", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "Se tendrá que presentar prueba PCR de 2 días máximo de antelación y certificado COVID",
				recinto, "Copla");

		// When
		serviceTest.saveEvent(event);
		serviceTest.saveEvent(event2);
		int expected = 2;
		List<EventResponse> lista = serviceTest.findByNombre("salerosa");

		// Then
		assertThat(expected).isEqualTo(lista.size());

	}

	
	void shouldBeAnEmptyListWhenFindByGenero() {
		// Given
		Integer[] rangoPrecios = { 10, 20 };
		Recinto recinto = new Recinto(1, "Sala Apolo", "Madrid", "Calle Alcalá", 4000);

		Event event = new Event(1, "Isabel Pantoja", "Concierto de Isabel Pantoja",
				"Concierto por el aniverarsio de la carrera de Isabel Pantoja", "", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "Se tendrá que presentar prueba PCR de 2 días máximo de antelación y certificado COVID",
				recinto, "Copla");

		// When
		serviceTest.saveEvent(event);
		int expected = 0;
		List<EventResponse> lista = serviceTest.findByGenero("Punk");

		// Then
		assertThat(expected).isEqualTo(lista.size());

	}

	
	void shouldBeAnEmptyListWhenFindByNombre() {
		// Given
		Integer[] rangoPrecios = { 10, 20 };
		Recinto recinto = new Recinto(1, "Sala Apolo", "Madrid", "Calle Alcalá", 4000);

		Event event = new Event(1, "Isabel Pantoja", "Concierto de Isabel Pantoja",
				"Concierto por el aniverarsio de la carrera de Isabel Pantoja", "", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "Se tendrá que presentar prueba PCR de 2 días máximo de antelación y certificado COVID",
				recinto, "Copla");

		Event event2 = new Event(2, "Isa Pantoja", "Concierto de Isa Pantoja",
				"Concierto por el aniverarsio de la carrera de Isa Pantoja", "", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "Se tendrá que presentar prueba PCR de 2 días máximo de antelación y certificado COVID",
				recinto, "Copla");
		// When
		serviceTest.saveEvent(event);
		serviceTest.saveEvent(event2);
		int expected = 0;
		List<EventResponse> lista = serviceTest.findByNombre("Manolo");

		// Then
		System.out.println(lista);
		assertThat(expected).isEqualTo(lista.size());
	}

	@Test
	void shouldDeleteAnEventById() {

		// Given
		Integer[] rangoPrecios = { 10, 20 };
		Recinto recinto = new Recinto(1, "Sala Apolo", "Madrid", "Calle Alcalá", 4000);

		Event event = new Event(1, "Isabel Pantoja", "Concierto de Isabel Pantoja",
				"Concierto por el aniverarsio de la carrera de Isabel Pantoja", "", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "Se tendrá que presentar prueba PCR de 2 días máximo de antelación y certificado COVID",
				recinto, "Copla");

		// When
		List<EventResponse> lista = serviceTest.findAll();
		int inicial = lista.size();
		serviceTest.saveEvent(event);
		List<EventResponse> lista2 = serviceTest.findAll();
		int sizeAntesDeEliminar = lista2.size();
		serviceTest.delete(event);
		int sizeDespues = lista.size();

		// Then

		assertThat(sizeAntesDeEliminar).isEqualTo(sizeDespues + 1);
	}

	@Test
	void shouldEqualsAnEventAndItsModifiedWithoutChanges() {

		// Given
		Integer[] rangoPrecios = { 10, 20 };
		Recinto recinto = new Recinto(1, "Sala Apolo", "Madrid", "Calle Alcalá", 4000);

		Event event = new Event(1, "Isabel Pantoja", "Concierto de Isabel Pantoja",
				"Concierto por el aniverarsio de la carrera de Isabel Pantoja", "", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "Se tendrá que presentar prueba PCR de 2 días máximo de antelación y certificado COVID",
				recinto, "Copla");

		// When
		serviceTest.saveEvent(event);
		List<EventResponse> lista = serviceTest.findAll();
		serviceTest.updateEvent(event);
		List<EventResponse> lista2 = serviceTest.findAll();

		// Then
		assertThat(lista.toString()).isEqualTo(lista2.toString());
	}

}
