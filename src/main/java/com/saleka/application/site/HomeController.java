package com.saleka.application.site;

import com.saleka.application.configuration.ConfigurationService;
import com.saleka.application.configuration.ConfigurationSite;
import com.saleka.application.notification.client.Client;
import com.saleka.application.notification.client.ClientService;
import com.saleka.application.notification.message.Message;
import com.saleka.application.notification.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private ConfigurationService configurationService;
    private MessageService messageService;
    private ClientService clientService;

    @Autowired
    public HomeController(ConfigurationService configurationService, MessageService messageService, ClientService clientService) {
        this.configurationService = configurationService;
        this.messageService = messageService;
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<ConfigurationSite> configurationAllSite = configurationService.getAllSiteConfigurations();
        model.addAttribute("site", configurationAllSite);
        return "site/home";
    }

    @GetMapping("/services")
    public String services(Model model){
        List<ConfigurationSite> configurationAllSite = configurationService.getAllSiteConfigurations();
        model.addAttribute("site", configurationAllSite);

        return "site/services";
    }
    @GetMapping("/about")
    public String about(Model model){
        List<ConfigurationSite> configurationAllSite = configurationService.getAllSiteConfigurations();
        model.addAttribute("site", configurationAllSite);
        return "site/about";
    }
    @GetMapping("/default")
    public String defaut(Model model){
        model.addAttribute(configurationService.getAllSiteConfigurations());
        model.addAttribute("email",new Message());
        return "site/layouts/default";
    }
}
