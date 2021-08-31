package com.saleka.application.notification.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> listClients(){
        return clientRepository.findAll();
    }
    public Client save(@Valid Client client){
        return clientRepository.save(client);
    }
    public Client findById(Long id){
        return clientRepository.findById(id).orElseThrow(() -> new IllegalStateException("No Client Found... Please pass a correct ID"));
    }

    public Client findByEmail(String email){
        return clientRepository.findByEmail(email).orElseThrow(()->new IllegalStateException("No Client Found"));
    }
    public Client addClient(@NotNull @Valid Client client){
        if(clientRepository.existsByEmail(client.getEmail())){
            client.setId(findByEmail(client.getEmail()).getId());
        }
        return clientRepository.saveAndFlush(client);
    }
    public Client addClient(@NotNull @Valid Client client,Long id){
        if(clientRepository.existsById(id)){
            client.setId(id);
        }
        return clientRepository.saveAndFlush(client);
    }
    public boolean removeClient(@NotNull @Valid Client client){
        if(clientRepository.deleteClientByEmail(client.getEmail()) == 1){
            return true;
        }
        return false;
    }
    public void removeClient(Long id){
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
        }
    }
}
