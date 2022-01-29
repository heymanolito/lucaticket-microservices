package com.grupo1.lucaticket.controller;

import com.grupo1.lucaticket.model.Event;
import com.grupo1.lucaticket.model.Recinto;
import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.grupo1.lucaticket.Constants.*;
import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EventControllerTest {

    @DisplayName("GET | LISTAR EVENTOS")
    @Test
    void shouldGetEventList() {
        RestAssured.given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .get(EVENTS_ENDPOINT)
                .getBody()
                .prettyPrint();
    }
    
    @DisplayName("GET | FILTRAR EVENTOS POR GENERO")
    @Test
    void shouldGetEventListFiltredByGenero() {
        RestAssured.given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .pathParam("genero", "copla")
                .get(EVENTS_BY_GENERO)
                .getBody()
                .prettyPrint();

    }

    @DisplayName("GET | LISTAR EVENTOS POR ID")
    @Test
    public void shouldGetEventById() {
        given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .pathParam("id", "1")
                .get(ID_EVENTS_ENDPOINT)
                .getBody()
                .prettyPrint();
    }

    @DisplayName("POST | AÑADIR NUEVO EVENTO")
    @Test
    public void shouldAddNewEvent() {
        Integer[] rangoPrecios = {10, 20};
        Recinto recinto = new Recinto(1, "Sala pepe", "Badalona", "Calle Jaume", 4000);

        Event event = new Event(0, "La pantoja", "hola", "adios", "GDSGDS", LocalDate.now(), LocalTime.now(), rangoPrecios, "hola", recinto,"copla");

        given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body(event).expect().statusCode(201).when().post(EVENTS_ADD_ENDPOINT);

        given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .pathParam("id", "5")
                .get(ID_EVENTS_ENDPOINT)
                .getBody()
                .prettyPrint();
    }


}
