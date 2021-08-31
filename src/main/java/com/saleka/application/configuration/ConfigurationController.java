package com.saleka.application.configuration;

import com.saleka.application.security.User;
import com.saleka.application.security.UserPrincipal;
import com.saleka.application.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class ConfigurationController {
    @Autowired
    private UserRepository userRepository;
    
    private final ConfigurationService configurationService;

    @Autowired
    public ConfigurationController( ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @GetMapping()
    public List<ConfigurationSite> getConfigurations(Model model){

        return configurationService.getAllSiteConfigurations();
    }

    @PostMapping("/upload/images")
    public String savePhoto(@RequestParam("image") MultipartFile multipartFile, @RequestParam(value = "location") String location) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if (location.equals("userprofile")){
            UserPrincipal connectedUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userRepository.findByEmail(connectedUser.getEmail());
            user.setImage(fileName);
            userRepository.saveAndFlush(user);

            String uploadDir = "src/main/resources/static/media/images/profiles/" + user.getId() + "/";

            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        }
        if (location.equals("homepage")){
            List<ConfigurationSite> repo = configurationService.getConfigurationSite();
            ConfigurationSite configurationSiteA = repo.get(0);
            configurationSiteA.setImagePrincipal(fileName);
            configurationService.save(configurationSiteA);

            String uploadDir = "src/main/resources/static/media/images/site/";

            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        }
        


        return "redirect:/admin/dashboard";
    }
}
