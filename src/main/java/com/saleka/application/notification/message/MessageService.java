package com.saleka.application.notification.message;

import com.saleka.application.notification.client.Client;
import com.saleka.application.notification.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    ClientRepository clientRepository;

    public List<Message> listMessages(){
        return messageRepository.findAll();
    }
    public Page<Message> listMessages(int page, int size){
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Message> messages = messageRepository.findAll(pageable);
        if(messages ==null){
            throw new IllegalStateException(("Error Found"));
        }
        return messages;
    }
    public List<Message> listMessages(Date date){
        return messageRepository.findMessageByDateAfter(date);
    }

//    public Page<Message> listRecentMessages(int page,int size){
//        Pageable pageable = PageRequest.of(page-1,size);
//        Page<Message> messages = messageRepository.findAllByOrOrderByDateDesc(pageable);
//        if(messages ==null){
//            throw new IllegalStateException(("Error Found"));
//        }
//        return messages;
//    }
    public Message addMessage(@NotNull @Valid Message message){
        Client client = message.getClient();
        if(!clientRepository.existsByEmail(client.getEmail())){
            clientRepository.saveAndFlush(message.getClient());
        }else{
            client.setId(
                    clientRepository.findByEmail(
                            client.getEmail()
                    ).get().getId()
            );
            clientRepository.saveAndFlush(client);
        }
        return messageRepository.saveAndFlush(message);
    }
    public Message addMessage(@NotNull @Valid Message message,Long id){
        Client client = message.getClient();
        if(clientRepository.existsById(id)){
            client.setId(id);
            clientRepository.saveAndFlush(client);
        }
        return messageRepository.saveAndFlush(message);
    }
    public Message findById(Long id){
        return messageRepository.findById(id).orElseThrow(() -> new IllegalStateException("No Message Found... Please pass a correct ID"));
    }
    public List<Message> findByClient(Client client){
        return messageRepository.findAllByClient(client);
    }
    public List<Message> findByClient_Email(String email){
        return messageRepository.findAllByClient_Email(email);
    }

    public void delete(Long id){
        messageRepository.deleteById(id);
    }

}
