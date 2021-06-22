package com.saleka.application.site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){

        return "site/home";
    }
    @GetMapping("/contact")
    public String contact(){

        return "site/contact";
    }
    @GetMapping("/services")
    public String services(){

        return "site/services";
    }
    @GetMapping("/about")
    public String about(){

        return "site/about";
    }
}
