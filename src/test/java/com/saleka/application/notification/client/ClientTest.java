package com.saleka.application.notification.client;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private static Validator validator;
    private Client client;
    @BeforeAll
    public static void setupValidatorInstance(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    @BeforeEach
    public void initClient(){
        client = new Client();
    }

    @AfterEach
    public void resetClient(){
        client = null;
    }

    @Test
    public void whenValidEmail_thenNoConstraintViolation(){
        client.setEmail("kouam@gmail.com");
        Set<ConstraintViolation<Client>> violations = validator.validate(client);
        assertEquals(violations.size(),0);
    }
    @Test
    public void whenNullEmail_thenOneConstraintViolation(){
        Set<ConstraintViolation<Client>> violations = validator.validate(client);
        assertEquals(violations.size(),1);
    }
    @Test
    public void whenNotValidEmail_thenOneConstraintViolation(){
        client.setEmail("kouam");
        Set<ConstraintViolation<Client>> violations = validator.validate(client);
        assertEquals(violations.size(),1);
    }

}