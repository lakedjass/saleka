package com.saleka.application.admin;

import com.saleka.application.configuration.ConfigurationService;
import com.saleka.application.configuration.ConfigurationSite;
import com.saleka.application.notification.message.Message;
import com.saleka.application.notification.message.MessageService;
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

    @Autowired
    private MessageService messageService;

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
                                        @RequestParam(required = false) String bloc2WhyusBoite3SousTitre,@RequestParam(required = false) String bloc1AboutVideo,
                                        @RequestParam(required = false) String bloc2AboutTitre1,@RequestParam(required = false) String bloc2AboutTitre2,
                                        @RequestParam(required = false) String bloc2AboutSousTitre2,@RequestParam(required = false) String salekaBloc3AboutTitre1,
                                        @RequestParam(required = false) String salekaBloc3AboutSousTitre1,@RequestParam(required = false) String salekaBloc3AboutTitre2,
                                        @RequestParam(required = false) String salekaBloc3AboutSousTitre2,@RequestParam(required = false) String salekaBloc3AboutTitre3,
                                        @RequestParam(required = false) String salekaBloc3AboutSousTitre3,@RequestParam(required = false) String titreService,
                                        @RequestParam(required = false) String descriptionService,@RequestParam(required = false) String bloc1ServiceTitre1,
                                        @RequestParam(required = false) String bloc1ServiceSoustitre1,@RequestParam(required = false) String bloc1ServiceTitre2,
                                        @RequestParam(required = false) String bloc1ServiceSoustitre2,@RequestParam(required = false) String bloc1ServiceTitre3,
                                        @RequestParam(required = false) String bloc1ServiceSoustitre3,@RequestParam(required = false) String ourMissionTitre,
                                        @RequestParam(required = false) String ourMissionDescription,
                                        @RequestParam(required = false) String ourPlanTitre, @RequestParam(required = false) String ourPlanDescription,
                                        @RequestParam(required = false) String contactDescription, @RequestParam(required = false) String adresse,
                                        @RequestParam(required = false) String newsletterDescription){

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
            if(bloc1AboutVideo != null){
                configurationSiteA.setBloc1AboutVideo(bloc1AboutVideo);
            }
            if(bloc2AboutTitre1 != null){
                configurationSiteA.setBloc2AboutTitre1(bloc2AboutTitre1);
            }
            if(bloc2AboutTitre2 != null){
                configurationSiteA.setBloc2AboutTitre2(bloc2AboutTitre2);
            }
            if(bloc2AboutSousTitre2 != null){
                configurationSiteA.setBloc2AboutSousTitre2(bloc2AboutSousTitre2);
            }

            if(salekaBloc3AboutTitre1 != null){
                configurationSiteA.setBloc3AboutTitre1(salekaBloc3AboutTitre1);
            }
            if(salekaBloc3AboutSousTitre1 != null){
                configurationSiteA.setBloc3AboutSousTitre1(salekaBloc3AboutSousTitre1);
            }
            if(salekaBloc3AboutTitre2 != null){
                configurationSiteA.setBloc3AboutTitre2(salekaBloc3AboutTitre2);
            }
            if(salekaBloc3AboutSousTitre2 != null){
                configurationSiteA.setBloc3AboutSousTitre2(salekaBloc3AboutSousTitre2);
            }
            if(salekaBloc3AboutTitre3 != null){
                configurationSiteA.setBloc3AboutTitre3(salekaBloc3AboutTitre3);
            }
            if(salekaBloc3AboutSousTitre3 != null){
                configurationSiteA.setBloc3AboutSousTitre3(salekaBloc3AboutSousTitre3);
            }

            if(titreService != null){
                configurationSiteA.setTitreService(titreService);
            }
            if(descriptionService != null){
                configurationSiteA.setDescriptionService(descriptionService);
            }
            if(bloc1ServiceTitre1!=null){
                configurationSiteA.setBloc1ServiceTitre1(bloc1ServiceTitre1);
            }
            if(bloc1ServiceSoustitre1 != null){
                configurationSiteA.setBloc1ServiceSoustitre1(bloc1ServiceSoustitre1);
            }
            if(bloc1ServiceTitre2!=null){
                configurationSiteA.setBloc1ServiceTitre2(bloc1ServiceTitre2);
            }
            if(bloc1ServiceSoustitre2 != null){
                configurationSiteA.setBloc1ServiceSoustitre2(bloc1ServiceSoustitre2);
            }
            if(bloc1ServiceTitre3!=null){
                configurationSiteA.setBloc1ServiceTitre3(bloc1ServiceTitre3);
            }
            if(bloc1ServiceSoustitre3 != null){
                configurationSiteA.setBloc1ServiceSoustitre3(bloc1ServiceSoustitre3);
            }
            if(ourMissionTitre != null){
                configurationSiteA.setOurMissionTitre(ourMissionTitre);
            }
            if(ourMissionDescription != null){
                configurationSiteA.setOurMissionDescription(ourMissionDescription);
            }

            if(ourPlanTitre != null){
                configurationSiteA.setOurPlanTitre(ourPlanTitre);
            }
            if(ourPlanDescription != null){
                configurationSiteA.setOurPlanDescription(ourPlanDescription);
            }
            if(adresse != null){
                configurationSiteA.setAdresse(adresse);
            }
            if(contactDescription != null){
                configurationSiteA.setContactDescription(contactDescription);
            }
            if(newsletterDescription != null){
                configurationSiteA.setNewsletterDescription(newsletterDescription);
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


