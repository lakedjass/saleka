package com.saleka.application.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {

    @Autowired
    private ConfigurationSiteRepository configurationSiteRepository;

    @Autowired
    public ConfigurationService(ConfigurationSiteRepository configurationSiteRepository) {
        this.configurationSiteRepository = configurationSiteRepository;
    }

    public List<ConfigurationSite> getAllSiteConfigurations() {
        return configurationSiteRepository.findAll();

    }

    public List<ConfigurationSite> getConfigurationSite(){

        return configurationSiteRepository.findAll();
    }


    public void save(ConfigurationSite configurationSiteA) {
      configurationSiteRepository.saveAndFlush(configurationSiteA);
    }
}
