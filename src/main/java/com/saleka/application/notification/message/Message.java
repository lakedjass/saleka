package com.saleka.application.notification.message;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.saleka.application.notification.client.Client;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne
    @JsonManagedReference
    @NotNull(message = "le client ne peut etre null")
    private Client client;

    @Column(nullable = false, columnDefinition = "TEXT", length = 255)
    @NotBlank(message = "le sujet ne peut etre vide")
    private String subject;

    @Column(nullable = false, columnDefinition = "TEXT", length = 500)
    @NotBlank(message = "le message est obligatoire")
    private String body;

    private Date date;

    public Message(){
        this.date = new Date();
    }

    public Message(Client client,String subject,String body) {
        this.client = client;
        this.subject = subject;
        this.body = body;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public java.util.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
