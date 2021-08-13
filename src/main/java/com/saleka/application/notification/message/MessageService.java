package com.saleka.application.notification.message;

import com.saleka.application.notification.client.Client;
import com.saleka.application.notification.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Message newMessage(Long id){
        Message message = new Message();
        if(id==null){
            message.setClient(new Client());
        }else {
            message = newMessage(clientRepository.getById(id));
        }
        return message;
    }
    public Message newMessage(Client client){
        Message message = new Message();
        message.setClient(client);
        return message;
    }
    public Message findById(Long id){
        return messageRepository.findById(id).orElseThrow(() -> new IllegalStateException("No Message Found... Please pass a correct ID"));
    }
    public Client getByClient(Client client){
        return messageRepository.findByClient(client);
    }
    
    public Message saveMessage(Message message){
        if(message == null){
            throw new IllegalStateException("Message Not Found");
        }
        messageRepository.saveAndFlush(message);
        return message;
    }
    public void delete(Long id){
        messageRepository.deleteById(id);
    }
    @Transactional
    public Message updateMessage(Long id, Message message){
        if(message == null){
            throw new IllegalStateException("the Update couldn't be resolved");
        }
        if(messageRepository.existsById(id)){
            message.setId(id);
            messageRepository.saveAndFlush(message);
        }
        return message;
    }
}
