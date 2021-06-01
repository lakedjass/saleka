package com.saleka.application.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigurationController {

    @GetMapping("/admin/configuration")
    public String home(){

        return "configuration/home";
    }
}
