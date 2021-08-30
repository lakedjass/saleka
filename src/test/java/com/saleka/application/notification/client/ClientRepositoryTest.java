package com.saleka.application.notification.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ClientRepositoryTest {
    @Autowired
    ClientRepository clientRepository;
    @Test
    void itshouldReturnStudentWhenStudentfindByEmail() {
        //Given
        String email = "kouam@gmail.com";
        Client client = new Client(email,"junior");
        clientRepository.saveAndFlush(client);
        Optional<Client> check = clientRepository.findByEmail(email);
        assertThat(check)
                .isPresent()
                .get()
                .isNotNull()
                .extracting(Client::getEmail)
                .isEqualTo(email);
    }
    @Test
    void itshouldReturnNullWhenNotStudentfindByEmail() {
        //Given
        String email = "kouam@gmail.com";
        Optional<Client> check = clientRepository.findByEmail(email);
        assertThat(check)
                .isNotPresent();
    }

    @Test
    void itShouldCheckWhenStudentExistsByEmail() {
        //Given
        String email = "kouam@gmail.com";
        Client client = new Client(email,"junior");
        clientRepository.saveAndFlush(client);
        boolean check = clientRepository.existsByEmail(email);
        assertThat(check).isTrue();
    }
    @Test
    void itShouldCheckWhenStudentNoExistsByEmail() {
        //Given
        String email = "kouam@gmail.com";
        boolean check = clientRepository.existsByEmail(email);
        assertThat(check).isFalse();
    }

    @Test
    void test(){
        //Given
        String email = "kouam@gmail.com";
        Client client = new Client(email,"junior");
        Client client1 = new Client("ouat@gmail.com","junior");
        clientRepository.saveAndFlush(client);
        clientRepository.saveAndFlush(client1);
        List<Client> check = clientRepository.findAllByEmailContaining("oua");
        assertThat(check)
                .isNotNull()
                .containsExactlyInAnyOrder(client,client1);
    }
    @Test
    void test1(){
        //Given
        String email = "kouam@gmail.com";
        Client client = new Client(email,"junior");
        clientRepository.saveAndFlush(client);
        Integer s = clientRepository.deleteClientByEmail("xnb,wx");
        if(s == 1){
            assertThat(true).isTrue();
        }else
            fail("Pas supprimer");
    }
}