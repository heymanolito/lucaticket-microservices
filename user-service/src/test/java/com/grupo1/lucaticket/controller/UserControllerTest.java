package com.grupo1.lucaticket.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.grupo1.lucaticket.model.UserEntity;
import static com.grupo1.lucaticket.Constants.*;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerTest {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@DisplayName("POST | AÑADIR NUEVO USUARIO")
	@Test
	public void shouldAddNewEvent() {
		
		UserEntity user = UserEntity.builder()
				.username("manolito69")
				.password("234234")
				.fullName("Manolito Gallardo BadGyaler")
				.email("manolitoBadGYal@gmail.com")
				.roles(null).build();
		log.info("***************************" + user.getId());
		RestAssured.given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).body(user).expect().statusCode(201)
		.when().post(USER_ENDPOINT);
		
		
		given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).pathParam("id",user.getId())
		.get(ID_USER_ENDPOINT).getBody().prettyPrint();
	}

}
