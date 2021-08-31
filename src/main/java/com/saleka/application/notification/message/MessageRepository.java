package com.saleka.application.notification.message;


import com.saleka.application.notification.client.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
     List<Message> findAllByClient(Client client);
     List<Message> findAllByClient_Email(String email);
     List<Message> findAllByClient_Name(String name);
     List<Message> findMessageByDateAfter(Date date);
     Integer countMessageByClient_Email(String email);
}

