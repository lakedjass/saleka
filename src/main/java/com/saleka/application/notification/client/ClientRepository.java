package com.saleka.application.notification.client;

import com.saleka.application.notification.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    public Client findByEmail(String email);
}
