package com.saleka.application.notification.message;

import com.saleka.application.notification.client.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    private static Validator validator;
    private static Client client;
    private Message message;
    private static ConstraintViolation<Message> subject;
    @BeforeAll
    public static void setupValidatorInstance(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        client = new Client();
        client.setEmail("kouam@gmail.com");
    }
    @BeforeEach
    public void initMessage(){
        message = new Message();
        message.setClient(client);
        message.setBody("body");
        message.setSubject("subject");
    }

    @AfterEach
    public void resetMessage(){
        message = null;
    }

    @Test
    public void whenAllValid_thenNoConstraintViolation(){
        Set<ConstraintViolation<Message>> violations = validator.validate(message);
        assertEquals(violations.size(),0);
    }
    @Test
    public void whenNullClient_thenOneConstraintViolation(){
        message.setClient(null);
        Set<ConstraintViolation<Message>> violations = validator.validate(message);
        assertEquals(violations.size(),1);
    }
    @Test
    public void whenEmptySubject_thenOneConstraintViolation(){
        message.setSubject("");
        Set<ConstraintViolation<Message>> violations = validator.validate(message);
        assertThat(violations)
                .hasSize(1)
                .extracting(ConstraintViolation::getMessage)
                .contains("le sujet ne peut etre vide");
    }
    @Test
    public void whenBlankSubject_thenOneConstraintViolation(){
        message.setSubject(" ");
        Set<ConstraintViolation<Message>> violations = validator.validate(message);
        assertThat(violations)
                .hasSize(1)
                .extracting(ConstraintViolation::getMessage)
                .contains("le sujet ne peut etre vide");
    }
    @Test
    public void whenBlankBody_thenOneConstraintViolation(){
        message.setBody(" ");
        Set<ConstraintViolation<Message>> violations = validator.validate(message);
        assertThat(violations)
                .hasSize(1)
                .extracting(ConstraintViolation::getMessage)
                .contains("le message est obligatoire");
    }
    @Test
    public void whenNullBody_thenOneConstraintViolation(){
        message.setBody(null);
        Set<ConstraintViolation<Message>> violations = validator.validate(message);
        assertThat(violations)
                .hasSize(1)
                .extracting(ConstraintViolation::getMessage)
                .contains("le message est obligatoire");
    }
    @Test
    public void whenEmptyBody_thenOneConstraintViolation(){
        message.setBody("");
        Set<ConstraintViolation<Message>> violations = validator.validate(message);
        assertThat(violations)
                .hasSize(1)
                .extracting(ConstraintViolation::getMessage)
                .contains("le message est obligatoire");
    }
}