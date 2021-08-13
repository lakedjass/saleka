package com.saleka.application.notification.message;


import com.saleka.application.notification.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    public Client findByClient(Client client);
}
