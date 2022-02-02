package com.grupo1.lucaticket.controller;

import static com.grupo1.lucaticket.Constants.ADD_USER_ENDPOINT;
import static com.grupo1.lucaticket.Constants.BASE_URL;
import static com.grupo1.lucaticket.Constants.DELETE_USER_ENDPOINT;
import static com.grupo1.lucaticket.Constants.ID_USER_ENDPOINT;
import static com.grupo1.lucaticket.Constants.TOKEN;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.grupo1.lucaticket.model.UserEntity;
import com.grupo1.lucaticket.model.UserRole;
import com.grupo1.lucaticket.service.UserEntityService;

import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerTest {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserEntityService ens;

	@Autowired
	PasswordEncoder password;
	
	private String logear="{\"email\":\"manolitoBadBeach4@gmail.com\",\"password\":\"hola\"}";
	private String token="";

	@DisplayName("POST | AÑADIR NUEVO USUARIO")
	@Test
	public void shouldAddNewUser() {

		UserEntity user = UserEntity.builder().id(1L).username("manolito69").password("hola").password2("hola")
				.fullName("Manolito Gallardo BadGyaler").email("manolitoBadBeach4@gmail.com")
				.roles(Stream.of(UserRole.ADMIN).collect(Collectors.toSet())).build();

		log.info("***************************" + user.getId());

		given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).body(user).when().post(ADD_USER_ENDPOINT).then().assertThat().statusCode(201);

		
		
		given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).pathParam("id", "76")
				.get(ID_USER_ENDPOINT).then().body("id", equalTo(76)).extract().body().jsonPath().prettyPrint();

	}
	@DisplayName("GET | BUSCAR USUARIO POR ID")
	@Test
	public void shouldSearchAnUserById() {
		given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).pathParam("id", "76")
		.get(ID_USER_ENDPOINT).then().body("id", equalTo(76)).extract().body().jsonPath().prettyPrint();
		
	}
	
	@DisplayName("DELETE | BORRAR EVENTO POR ID")
	@Test
	void shouldDeleteTheUser() {
		Map<String, String> headers= new HashMap<String, String>(){
			{
				put("Accept","application/json");
				put("Authorization","Bearer " + TOKEN);
			}
		};
		
		given().headers(headers).baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).pathParam("id", "76").expect()
		.statusCode(204).when().delete(DELETE_USER_ENDPOINT);
		
		given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).pathParam("id", "76")
		.get(ID_USER_ENDPOINT).then().extract().body().jsonPath();
	}

}
