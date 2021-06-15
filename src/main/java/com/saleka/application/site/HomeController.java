package com.saleka.application.site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(ModelMap modelMap){

       // modelMap.put("name","bonjour tout le monde de thymeleaf");
        return "site/home";
    }
}
