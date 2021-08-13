package com.saleka.application.notification.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients(){
        return clientService.listClients();
    }

    @PostMapping
    public Client newClient(@RequestBody @Valid Client client){
//        if(bindingResult.hasErrors()){
//            return null;
//        }
        return clientService.newClient(client);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long id){
        clientService.delete(id);
        return ResponseEntity.ok().body("Suppression");
    }

    @PutMapping(path = "{id}")
    public Client updateClient(@PathVariable("id") Long id,@RequestBody @Valid Client client){
        return clientService.updateClient(id,client);
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
