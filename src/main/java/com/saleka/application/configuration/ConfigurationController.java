package com.saleka.application.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/configuration")
public class ConfigurationController {

    private final ConfigurationService configurationService;

    @Autowired
    public ConfigurationController( ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @GetMapping()
    public List<ConfigurationSite> getConfigurations(Model model){



        return configurationService.getConfigurations();
    }
}
