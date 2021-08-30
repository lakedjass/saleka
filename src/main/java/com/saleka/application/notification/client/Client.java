package com.saleka.application.notification.client;

import com.fasterxml.jackson.annotation.*;
import com.saleka.application.notification.message.Message;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    @Email(message = "l'email doit etre valide",regexp ="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @NotNull(message = "l'email ne doit pas etre nul")
    private String email;

    private Boolean newsLetter;

    @OneToMany(mappedBy = "client" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Message> mailList;

    public Client() {
        mailList = new ArrayList<>();
    }

    public Client(String email,String name) {
        this.name = name;
        this.email = email;
        mailList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Message> getMailList() {
        return mailList;
    }

    public void setMailList(List<Message> mailList) {
        this.mailList = mailList;
    }

    public Boolean getNewsLetter() {
        return newsLetter;
    }

    public void setNewsLetter(Boolean newsLetter) {
        this.newsLetter = newsLetter;
    }
}