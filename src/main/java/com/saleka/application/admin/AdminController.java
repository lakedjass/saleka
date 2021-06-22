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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "admin")
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
    public String getConfigurations(Model model){

        List<ConfigurationSite> configurations = configurationService.getConfigurations();
        UserPrincipal connectedUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", connectedUser);
        model.addAttribute("configurations", configurations);
        return "admin/configuration-list";
    }

    //add new configuration for site
    @PostMapping("/addConfiguration")
    public String addConfiguration(ConfigurationSite configurationSite){

        configurationService.saveConfigurationSite(configurationSite);

        return "redirect:/admin/listConfiguration";
    }

    @GetMapping("/journaux")
    public String getJournaux(){

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
    @PostMapping("/upload")
    public String savePhoto(@RequestParam("image") MultipartFile multipartFile) throws IOException {
        UserPrincipal connectedUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        User user = userRepository.findByEmail(connectedUser.getEmail());
        user.setImage(fileName);
        userRepository.saveAndFlush(user);
        String uploadDir = "src/main/resources/static/media/images/";

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return "redirect:/admin/dashboard";
    }
}


