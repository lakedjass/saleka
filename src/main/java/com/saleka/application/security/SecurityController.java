package com.saleka.application.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user){

        return "security/login";
    }

    @GetMapping("/logout")
    public String logout(){

        return "security/logout";
    }

    @GetMapping("/accessDenied")
    public String accessForbiden403(){

        return "security/accessDenied";
    }

    @GetMapping("/login-error")
    public String accesDenied(Model model){
        model.addAttribute("loginError", true);
        return "security/login";
    }






}
