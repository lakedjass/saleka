package com.saleka.application.site;

import com.saleka.application.configuration.ConfigurationService;
import com.saleka.application.configuration.ConfigurationSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ConfigurationService configurationService;

    @GetMapping("/")
    public String home(Model model){
        List<ConfigurationSite> configurationAllSite = configurationService.getAllSiteConfigurations();
        model.addAttribute("site", configurationAllSite);
        return "site/home";
    }
    @GetMapping("/contact")
    public String contact(Model model){
        List<ConfigurationSite> configurationAllSite = configurationService.getAllSiteConfigurations();
        model.addAttribute("site", configurationAllSite);
        return "site/contact";
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
}
