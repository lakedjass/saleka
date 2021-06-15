package com.saleka.application.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {

    private final ConfigurationSiteRepository configurationSiteRepository;

    @Autowired
    public ConfigurationService(ConfigurationSiteRepository configurationSiteRepository) {
        this.configurationSiteRepository = configurationSiteRepository;
    }

    public List<ConfigurationSite> getConfigurations() {
        return configurationSiteRepository.findAll();

    }

    public void saveConfigurationSite(ConfigurationSite configurationSite){

        configurationSiteRepository.save(configurationSite);
    }
}
