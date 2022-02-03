package com.grupo1.lucaticket.service;

import com.grupo1.lucaticket.model.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserEntityService serviceTest;

    @BeforeEach
    void setUp() {
        serviceTest.deleteAll();
    }

    @DisplayName("Given un usuario " + "When un usuario es añadido " + "Then se suma 1 a la base de datos")
    @Test
    void shouldAddEntryToDatabase() {
        // Given
        UserEntity user = UserEntity.builder().username("manolito69").password("234234")
                .fullName("Manolito Gallardo BadGyaler").email("manolitoBadGYal@gmail.com").roles(null).build();

        // When
        serviceTest.saveUser(user);
        int expected = 1;
        int actual = serviceTest.findAll().size();

        // Then
        assertThat(expected).isEqualTo(actual);

    }

    @DisplayName("Given unos usuarios " + "When un usuario es añadido "
            + "Then deberian estar todos los usuarios listados ")
    @Test
    void shouldListAllUsers() {

        // Given
        UserEntity user = UserEntity.builder().username("manolito69").password("234234")
                .fullName("Manolito Gallardo BadGyaler").email("manolitoBadGYal@gmail.com").roles(null).build();
        UserEntity user2 = UserEntity.builder().username("manolito69").password("234234")
                .fullName("Manolito Gallardo BadGyaler").email("sdsda@gmail.com").roles(null).build();
        UserEntity user3 = UserEntity.builder().username("manolito69").password("234234")
                .fullName("Manolito Gallardo BadGyaler").email("sdsdasdsadaYal@gmail.com").roles(null).build();
        // When
        serviceTest.saveUser(user);
        serviceTest.saveUser(user2);
        serviceTest.saveUser(user3);
        int expected = 3;
        int actual = serviceTest.findAll().size();

        // Then
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void shouldExistThisUser() {
        // Given
        UserEntity user = UserEntity.builder().username("manolito69").password("234234")
                .fullName("Manolito Gallardo BadGyaler").email("manolitoBadGYal@gmail.com").roles(null).build();

        //When
        serviceTest.saveUser(user);
        String expected = "manolito69";
        String actual = serviceTest.findAll().get(0).getUsername();

        //Then
        assertThat(expected).isEqualTo(actual);

    }

}
