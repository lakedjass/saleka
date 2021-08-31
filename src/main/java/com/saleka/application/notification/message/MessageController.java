package com.saleka.application.notification.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saleka.application.notification.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/message")
public class MessageController {

    private MessageService messageService;
    private ClientService clientService;
    @Autowired
    public MessageController(MessageService messageService, ClientService clientService) {
        this.messageService = messageService;
        this.clientService = clientService;
    }

    @GetMapping
    public List<Message> getMessages(@RequestParam(required = false)String date){
        if(date != null)
            return messageService.listMessages(new Date(Long.valueOf(date)));
        return messageService.listMessages();
    }

    @PostMapping
    public Message newMessage(@RequestBody @Valid Message message){
        return messageService.addMessage(message);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable("id") Long id){
        messageService.delete(id);
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public Message updateMessage(@PathVariable("id") Long id, @RequestBody Message message){
        return messageService.addMessage(message,id);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

