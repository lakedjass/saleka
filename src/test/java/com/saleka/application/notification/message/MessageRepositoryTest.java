package com.saleka.application.notification.message;

import com.saleka.application.notification.client.Client;
import com.saleka.application.notification.client.ClientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ClientRepository clientRepository;
    List<Message> messages ;
    List<Client> clients = List.of(
            new Client("kouam@gmail.com","kouam"),
            new Client("junior@gmail.com","junior")
    );
    @BeforeEach
    void setUp() {
        messages = List.of(
                new Message(clients.get(0),"salutation","yo junior"),
                new Message(clients.get(1),"re:salutation","yo kouam"),
                new Message(clients.get(1),"re:salutation","xdk?"),
                new Message(clients.get(0),"re:salutation","bien"),
                new Message(clients.get(0),"re:salutation","et toi?")
        );
    }

    @AfterEach
    void tearDown() {
        messages = null;
    }

    @Test
    void itShouldReturn03MessagesWhenMessagefindAllByClient() {
        //Given
        clientRepository.saveAll(clients);
        messageRepository.saveAll(messages);
        List<Message> result = messageRepository.findAllByClient(clients.get(0));

        assertThat(result)
                .isNotNull()
                .containsAll(
                        List.of(
                                messages.get(0),
                                messages.get(3),
                                messages.get(4)
                        )
                );
    }

    @Test
    void itshouldReturnEmptyListWhenNotMessagefindAllByClient(){
        //Given
        clientRepository.save(clients.get(0));
        List<Message> result = messageRepository.findAllByClient(clients.get(0));
        assertThat(result)
                .isEmpty();
    }
    @Test
    void itshouldReturnEmptyListWhenClientIsNullAndfindAllByClient() {
        //Given
        List<Message> result = messageRepository.findAllByClient(null);
        assertThat(result)
                .isEmpty();
    }
    @Test
    void itshouldReturnEmptyListWhenMessagesDoesNotExistAndfindAllByClient_Email() {
        //Given
        clientRepository.save(clients.get(0));
        List<Message> result = messageRepository.findAllByClient(clients.get(0));
        assertThat(result)
                .isEmpty();
    }
    @Test
    void itShouldReturnMessageWhenMessageOfClientWithEmailExist() {
        //Given
        clientRepository.saveAll(clients);
        messageRepository.saveAll(messages);
        List<Message> result = messageRepository.findAllByClient_Email(clients.get(0).getEmail());
        assertThat(result)
                .isNotNull()
                .containsAll(
                        List.of(
                                messages.get(0),
                                messages.get(3),
                                messages.get(4)
                        )
                );
    }

    @Test
    void itShouldReturnMessageWhenfindAllByClient_Name() {
        //Given
        clientRepository.saveAll(clients);
        messageRepository.saveAll(messages);
        List<Message> result = messageRepository.findAllByClient_Name(clients.get(0).getName());
        assertThat(result)
                .isNotNull()
                .containsAll(
                        List.of(
                                messages.get(0),
                                messages.get(3),
                                messages.get(4)
                        )
                );
    }

    @Test
    void test(){
        clientRepository.save(clients.get(0));
        Date date = new Date(1630164687042L);
//        LocalDate date = new LocalDate(1630164687042);
//        LocalDate date = LocalDate.now();
        String dateString = date.toString();
        messages.get(0).setDate(new Date(date.getTime()+1000));
        messageRepository.save(messages.get(0));
        List<Message> result = messageRepository.findMessageByDateAfter(date);
        assertThat(result)
                .isNotNull()
                .hasSize(1)
                .contains(
                        messages.get(0)
                );
    }
}