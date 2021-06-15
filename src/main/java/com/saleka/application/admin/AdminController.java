package com.saleka.application.admin;

import com.saleka.application.configuration.ConfigurationService;
import com.saleka.application.configuration.ConfigurationSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "admin")
public class AdminController {

    @Autowired
    private ConfigurationService configurationService;

    @Secured(value = {"ROLE_ADMIN"})
    @GetMapping("/dashboard")
    public String index(){

        return "admin/index";
    }

    @GetMapping("/listConfiguration")
    public String getConfigurations(Model model){
        List<ConfigurationSite> configurations = configurationService.getConfigurations();
        model.addAttribute("configurations", configurations);
        return "admin/configuration-list";
    }
    //add new configuration for site
    @PostMapping("/addConfiguration")
    public String addConfiguration(ConfigurationSite configurationSite){

        configurationService.saveConfigurationSite(configurationSite);

        return "redirect:/admin/listConfiguration";
    }
}
