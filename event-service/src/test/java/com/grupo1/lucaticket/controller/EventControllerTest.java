package com.grupo1.lucaticket.controller;

import static com.grupo1.lucaticket.Constants.BASE_URL;
import static com.grupo1.lucaticket.Constants.EVENTS_ADD_ENDPOINT;
import static com.grupo1.lucaticket.Constants.EVENTS_BY_CITY;
import static com.grupo1.lucaticket.Constants.EVENTS_BY_GENERO;
import static com.grupo1.lucaticket.Constants.EVENTS_BY_NOMBRE;
import static com.grupo1.lucaticket.Constants.EVENTS_ENDPOINT;
import static com.grupo1.lucaticket.Constants.EVENTS_UPDATE_ENDPOINT;
import static com.grupo1.lucaticket.Constants.ID_EVENTS_ENDPOINT;
import static io.restassured.RestAssured.given;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import com.grupo1.lucaticket.model.Event;
import com.grupo1.lucaticket.model.Recinto;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EventControllerTest {

	@Autowired
	EventController eventO;
	
	BindingResult result;

	@DisplayName("GET | LISTAR EVENTOS")
	@Test
	void shouldGetEventList() {
		RestAssured.given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).get(EVENTS_ENDPOINT)
				.getBody().prettyPrint();

	}

	@DisplayName("GET | FILTRAR EVENTOS POR NOMBRE")
	@Test
	void shouldGetEventListFiltredByNombre() {
		RestAssured.given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON)
				.pathParam("nombre", "salerosa").get(EVENTS_BY_NOMBRE).getBody().prettyPrint();

	}

	@DisplayName("DELETE | BORRAR EVENTO POR ID")
	@Test
	void shouldDeleteTheEvent() {
		Integer[] rangoPrecios = { 10, 20 };
		Recinto recinto = new Recinto(1, "Sala pepe", "Badalona", "Calle Jaume", 4000);

		Event event = new Event(1, "La pantoja", "hola", "adios", "GDSGDS", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "hola", recinto, "copla");

		
		 given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).body(event).expect().statusCode(204)
		.when().delete(EVENTS_ADD_ENDPOINT);

		
	}

	@DisplayName("GET | FILTRAR EVENTOS POR GENERO")
	@Test
	void shouldGetEventListFiltredByGenero() {
		RestAssured.given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON)
				.pathParam("genero", "copla").get(EVENTS_BY_GENERO).getBody().prettyPrint();

	}

	@DisplayName("GET | FILTRAR POR CIUDAD DE RECINTO")
	@Test
	void shouldGetEventListFiltredByCiudadRecinto() {
		RestAssured.given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON)
				.pathParam("ciudad", "Badalona").get(EVENTS_BY_CITY).getBody().prettyPrint();
	}

	@DisplayName("GET | LISTAR EVENTOS POR ID")
	@Test
	public void shouldGetEventById() {
		given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).pathParam("id", 1)
				.get(ID_EVENTS_ENDPOINT).getBody().prettyPrint();
	}

	@DisplayName("POST | AÑADIR NUEVO EVENTO")
	@Test
	public void shouldAddNewEvent() {
		Integer[] rangoPrecios = { 10, 20 };
		Recinto recinto = new Recinto(1, "Sala pepe", "Badalona", "Calle Jaume", 4000);

		Event event = new Event(1, "La pantoja", "hola", "adios", "GDSGDS", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "hola", recinto, "copla");

		given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).body(event).post(EVENTS_ADD_ENDPOINT)
				.getBody().prettyPrint();

	}

	@DisplayName("PUT | MODIFICAR EVENTO")
	@Test
	public void shouldUpdateAnEvent() {
		Integer[] rangoPrecios = { 10, 20 };
		Recinto recinto = new Recinto(1, "Sala pepe", "Badalona", "Calle Jaume", 4000);

		Event event = new Event(1, "La pantoja", "hola", "adios", "GDSGDS", LocalDate.now(), LocalTime.now(),
				rangoPrecios, "hola", recinto, "copla");
		Event event2 = new Event(1, "P", "hola", "adios", "GDSGDS", LocalDate.now(), LocalTime.now(), rangoPrecios,
				"hola", recinto, "copla");

		given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).body(event2)
				.put(EVENTS_UPDATE_ENDPOINT).getBody().prettyPrint();
	}

}
