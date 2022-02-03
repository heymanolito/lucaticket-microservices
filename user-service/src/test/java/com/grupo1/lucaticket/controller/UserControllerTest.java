package com.grupo1.lucaticket.controller;

import com.grupo1.lucaticket.model.UserEntity;
import com.grupo1.lucaticket.model.UserRole;
import com.grupo1.lucaticket.service.UserEntityServiceImpl;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.grupo1.lucaticket.Constants.ADD_USER_ENDPOINT;
import static com.grupo1.lucaticket.Constants.BASE_URL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@SpringBootTest
public class UserControllerTest {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserEntityServiceImpl userTest;
    @Autowired
    PasswordEncoder password;

    @DisplayName("POST | AÑADIR NUEVO USUARIO")
    @Test
    public void shouldAddNewEvent() {

        UserEntity user = UserEntity.builder().id(1L).username("manolito69").password(password.encode("hola"))
                .fullName("Manolito Gallardo BadGyaler").email("manolitoBadBeach2@gmail.com")
                .roles(Stream.of(UserRole.USER).collect(Collectors.toSet())).build();

        log.info("***************************" + user.getId());

        given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).body(user).post(ADD_USER_ENDPOINT);

        given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON).pathParam("id", 1L)
                .get().then().body("username", equalTo("manolito69")).extract().body().jsonPath()
                .prettyPrint();
    }

}
