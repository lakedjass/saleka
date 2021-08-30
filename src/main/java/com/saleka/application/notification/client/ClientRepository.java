package com.saleka.application.notification.client;

import com.saleka.application.notification.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByEmail(String email);
    List<Client> findAllByEmailContaining(String email);
    boolean existsByEmail(String email);
    Integer deleteClientByEmail(String email);
}
