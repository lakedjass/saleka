package com.saleka.application.admin;

import com.saleka.application.configuration.ConfigurationService;
import com.saleka.application.configuration.ConfigurationSite;
import com.saleka.application.security.User;
import com.saleka.application.security.UserPrincipal;
import com.saleka.application.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "admin",method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
public class AdminController {

    @Autowired
    private ConfigurationService configurationService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String index(Model model){
         UserPrincipal connectedUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         model.addAttribute("user", connectedUser);
        return "admin/index";
    }

    @GetMapping("/listConfiguration")
    public String getHomePageConfigurations(Model model){

        List<ConfigurationSite> configurationAllSite = configurationService.getAllSiteConfigurations();
        UserPrincipal connectedUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", connectedUser);
        model.addAttribute("configurations", configurationAllSite);
        return "admin/configuration-list";
    }

    //edit configuration for site
    @PostMapping(path = "/editSiteConfiguration")
    public String editSiteConfiguration(Model model,@RequestParam(required = false) int page,
                                        @RequestParam(required = false) String emailCorp, @RequestParam(required = false) String telCorp,
                                        @RequestParam(required = false) String sloganCorp, @RequestParam(required = false) String herotitre,
                                        @RequestParam(required = false) String heroSoustitre){

        List<ConfigurationSite> configurationAllSite = configurationService.getAllSiteConfigurations();
        ConfigurationSite configurationSiteA = configurationAllSite.get(0);

            if (emailCorp != null){
                configurationSiteA.setEmailCorp(emailCorp);
            }
            if (telCorp != null){
                configurationSiteA.setTelCorp(telCorp);
            }
            if (sloganCorp != null){
                configurationSiteA.setSloganCorp(sloganCorp);
            }
            if (herotitre != null){
                configurationSiteA.setTitrePrincipal(herotitre);
            }
            if (heroSoustitre != null){
                configurationSiteA.setSousTitrePrincipal(heroSoustitre);
            }
            if (page == 2){
                model.addAttribute("page", "Paramétrage About page");
                return "redirect:/admin/about-configuration";
            }

        configurationService.save(configurationSiteA);

        return "redirect:/admin/listConfiguration";
    }

    @GetMapping("/journaux")
    public String getJournaux(Model model){
        UserPrincipal connectedUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", connectedUser);
        return "admin/journauxModifHomePage";
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        List<User> usersList = userRepository.findAll();
        UserPrincipal connectedUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", connectedUser);
        model.addAttribute("usersList", usersList);
        return "admin/users";
    }


}


