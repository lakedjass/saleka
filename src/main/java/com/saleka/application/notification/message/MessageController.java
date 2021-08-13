package com.saleka.application.notification.message;

import com.saleka.application.notification.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    private MessageService messageService;
    private ClientService clientService;
    @Autowired
    public MessageController(MessageService messageService, ClientService clientService) {
        this.messageService = messageService;
        this.clientService = clientService;
    }

    @GetMapping
    public List<Message> getMessages(){
        return messageService.listMessages();
    }

    @PostMapping
    public Message newMessage(@RequestBody @Valid Message message, BindingResult result){
        if(result.hasErrors()){
            return null;
        }
        if(message.getClient() == null){
            return null;
        }else {
            if(message.getClient().getId() == null){
                clientService.newClient(message.getClient());
            }else{
                //clientService.updateClient(message.getClient().getId(), message.getClient());
            }
        }
        return messageService.saveMessage(message);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable("id") Long id){
        messageService.delete(id);
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public Message updateMessage(@PathVariable("id") Long id, @RequestBody Message message){
        return messageService.updateMessage(id, message);
    }
}

