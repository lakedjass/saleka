package com.saleka.application.notification.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.saleka.application.notification.message.Message;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
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
    @Email(message = "email invalid",regexp ="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @NotNull
    private String email;

    @OneToMany(mappedBy = "client" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    //@JsonManagedReference
    @JsonIgnore
    private List<Message> mailList;

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

}