package com.saleka.application.notification.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> listClients(){
        return clientRepository.findAll();
    }
    public Client save(Client client){
        return clientRepository.save(client);
    }
    public Client findById(Long id){
        return clientRepository.findById(id).orElseThrow(() -> new IllegalStateException("No Client Found... Please pass a correct ID"));
    }

    public Client findByEmail(String email){
        return clientRepository.findByEmail(email);
    }
    public Client newClient(Client client){
        if(client == null){
            throw new IllegalStateException("Client Not Found");
        }
        clientRepository.saveAndFlush(client);
        return client;
    }
    public void delete(Long id){
        clientRepository.deleteById(id);
    }
    @Transactional
    public Client updateClient(Long id, Client client){
        if(client == null){
            throw new IllegalStateException("The Update couldn't be resolved the Post object given was null");
        }
        if(clientRepository.existsById(id)){
            client.setId(id);
            clientRepository.saveAndFlush(client);
        }
        return client;
    }
}
