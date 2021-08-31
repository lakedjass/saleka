package com.saleka.application.site;

import com.saleka.application.configuration.ConfigurationService;
import com.saleka.application.configuration.ConfigurationSite;
import com.saleka.application.notification.client.Client;
import com.saleka.application.notification.client.ClientService;
import com.saleka.application.notification.message.Message;
import com.saleka.application.notification.Notifier;
import com.saleka.application.notification.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContactController {
    private ConfigurationService configurationService;
    private Notifier notifier;
    private MessageService messageService;
    private ClientService clientService;

    @Autowired
    public ContactController(ConfigurationService configurationService, Notifier notifier, MessageService messageService, ClientService clientService) {
        this.configurationService = configurationService;
        this.notifier = notifier;
        this.messageService = messageService;
        this.clientService = clientService;
    }
    @GetMapping("/contact")
    public String newcontact(Model model, @RequestParam(required = false) Long id){
        List<ConfigurationSite> configurationAllSite = configurationService.getAllSiteConfigurations();
        model.addAttribute("site", configurationAllSite);
//        if(id!=null){
//            model.addAttribute("client",clientService.findById(id));
//        }
        return "site/contact";
    }
    @PostMapping("/contact")
    public String newcontactPost(Model model, @RequestParam(required = false) Long id){
        List<ConfigurationSite> configurationAllSite = configurationService.getAllSiteConfigurations();
        model.addAttribute("site", configurationAllSite);
        if(id!=null){
            model.addAttribute("client",clientService.findById(id));
        }
        return "site/contact";
    }
    @GetMapping("/contact/{id}")
    public String contact(Model model, @PathVariable(value = "id",required = false) Long id){
        List<ConfigurationSite> configurationAllSite = configurationService.getAllSiteConfigurations();
        model.addAttribute("site", configurationAllSite);
//        if(id!=null){
//            model.addAttribute("client",clientService.findById(id));
//        }
        return "site/contact";
    }

    @PostMapping("/contact/newmessage")
    @ResponseBody
    public ResponseEntity contact( Message message, @Valid Client client,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<String>("Bad",HttpStatus.BAD_REQUEST);
        }
        message.setClient(client);
        message = messageService.addMessage(message);
        if(message != null){
            notifier.notify(message);
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
    @PostMapping("/addnewsletter")
    public ResponseEntity<String> newsLetter(Client client){
        client.setNewsLetter(true);
        clientService.addClient(client);

        Message message = new Message();
        message.setSubject("Ajout a la newsLetter");
        message.setBody("Vous nous suivez actuellement");
        message.setClient(client);
        message = messageService.addMessage(message);
        if(message != null){
            notifier.notify(message);
        }
        return new ResponseEntity<String>("OK",HttpStatus.OK);
    }


}
