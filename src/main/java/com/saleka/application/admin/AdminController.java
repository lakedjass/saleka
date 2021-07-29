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
    public String editSiteConfiguration(Model model,
                                        @RequestParam(required = false) String emailCorp, @RequestParam(required = false) String telCorp,
                                        @RequestParam(required = false) String sloganCorp, @RequestParam(required = false) String heroTitre,
                                        @RequestParam(required = false) String heroSousTitre, @RequestParam(required = false) String bloc1WhyusTitre,
                                        @RequestParam(required = false) String bloc1WhyusSousTitre, @RequestParam(required = false) String bloc2WhyusBoite1Titre,
                                        @RequestParam(required = false) String bloc2WhyusBoite1SousTitre,@RequestParam(required = false) String bloc2WhyusBoite2Titre,
                                        @RequestParam(required = false) String bloc2WhyusBoite2SousTitre,@RequestParam(required = false) String bloc2WhyusBoite3Titre,
                                        @RequestParam(required = false) String bloc2WhyusBoite3SousTitre){

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
            if (heroTitre != null){
                configurationSiteA.setTitrePrincipal(heroTitre);
            }
            if (heroSousTitre != null){
                configurationSiteA.setSousTitrePrincipal(heroSousTitre);
            }
            if(bloc1WhyusTitre != null){
                configurationSiteA.setBloc1WhyusTitre(bloc1WhyusTitre);
            }
            if(bloc1WhyusSousTitre != null){
                configurationSiteA.setBloc1WhyusSousTitre(bloc1WhyusSousTitre);
            }

            if(bloc2WhyusBoite1Titre != null){
                configurationSiteA.setBloc2WhyusBoite1Titre(bloc2WhyusBoite1Titre);
            }
            if(bloc2WhyusBoite1SousTitre != null){
                configurationSiteA.setBloc2WhyusBoite1SousTitre(bloc2WhyusBoite1SousTitre);
            }
            if(bloc2WhyusBoite2Titre != null){
                configurationSiteA.setBloc2WhyusBoite2Titre(bloc2WhyusBoite2Titre);
            }
            if(bloc2WhyusBoite2SousTitre != null){
                configurationSiteA.setBloc2WhyusBoite2SousTitre(bloc2WhyusBoite2SousTitre);
            }
            if(bloc2WhyusBoite3Titre != null){
                configurationSiteA.setBloc2WhyusBoite3Titre(bloc2WhyusBoite3Titre);
            }
            if(bloc2WhyusBoite3SousTitre != null){
                configurationSiteA.setBloc2WhyusBoite3SousTitre(bloc2WhyusBoite3SousTitre);
            }


        configurationService.save(configurationSiteA);

        return "redirect:listConfiguration";
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


