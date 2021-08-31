package com.saleka.application.site;

import com.saleka.application.configuration.ConfigurationSite;
import com.saleka.application.configuration.ConfigurationSiteRepository;
import com.saleka.application.security.User;
import com.saleka.application.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Scanner;

@Component
public class FixtureSite implements
        ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = true;
    @Autowired
    private ConfigurationSiteRepository configurationSiteRepository;
    private UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(alreadySetup){
            return;
        }
        if(userRepository.findAll().isEmpty()){
            System.out.println("\n\n\n\n\n les users ne sont pas encore prets \n\n\n\n\n");
            return;
        }
        List<User> users = userRepository.findAll();
        ConfigurationSite configurationSite = new ConfigurationSite();
        configurationSite.setTheme("Saleka Web Site");


        /**
         * TOP BAR FIXTURE
         */
        configurationSite.setEmailCorp("saleka@support.com");
        configurationSite.setTelCorp("+237 695267478");
        configurationSite.setSloganCorp("Votre Satisfaction, Notre Bonheur");

        /**
         * HERO SECTION
         */
        configurationSite.setTitrePrincipal("Bienvenue Chez Saleka");
        configurationSite.setSousTitrePrincipal("Nous sommes une entreprise de prestations de services informatiques");
        configurationSite.setImagePrincipal("saleka");

        /**
         * Why-US
         */
        //Bloc 1
        configurationSite.setBloc1WhyusTitre("Pourquoi nous Choisir pour vos projets informatiques");
        configurationSite.setBloc1WhyusSousTitre("Une jeune equipe dynamique à votre service.");

        //Bloc 2
        //Boite 1
        configurationSite.setBloc2WhyusBoite1Titre("Developpement d'apllications");
        configurationSite.setBloc2WhyusBoite1SousTitre("Nous développons des applications robustes et sophistiquées afin de booster la croissance de votre entreprise.");
        //Boite 2
        configurationSite.setBloc2WhyusBoite2Titre("Developpement d'applications Web");
        configurationSite.setBloc2WhyusBoite2SousTitre("Des applications ergonomiques et sécurisées, facilitant l’accès à vos services sur le web, afin d’accroître votre visibilité internationale.");

        //Boite 3
        configurationSite.setBloc2WhyusBoite3Titre("Developpement d'applications mobiles");
        configurationSite.setBloc2WhyusBoite3SousTitre("Nous améliorons vos produits logiciels pour les adapter au mieux à l’évolution de votre marché et de l’environnement socio-économique.");

        /**
         * Service
         */
        configurationSite.setTitreService("Des services de haute qualité à un prix abordable.");
        configurationSite.setDescriptionService("Non seulement nous fournissons des services fiables et de haute qualité, nous nous engageons également à les fournir à un prix abordable.");
        //Bloc 1
        configurationSite.setBloc1ServiceTitre1("Développement d’applications JAVA");
        configurationSite.setBloc1ServiceSoustitre1("Optez pour une application bénéficiant de la maturité du langage de programmation JAVA, à laquelle vous pourrez confier toutes les tâches lourdes et critiques de votre business.\n" +
                "\n" +
                "Nous concevons des applications d’entreprises JAVA taillées pour votre métier.");
        //bloc 2
        configurationSite.setBloc1ServiceTitre2("Développement d’APIs WEB");
        configurationSite.setBloc1ServiceSoustitre2("Que vous fassiez du B2C ou du B2B, appuyez-vous sur la puissance des APIs Web pour fournir vos services digitaux sur mesure à des milliers de clients à moindre coût.\n" +
                "\n" +
                "Développer des APIs oui, mais surtout les sécuriser: nous en sommes conscients et mettons ces avantages à votre portée.");
        //Bloc3
        configurationSite.setBloc1ServiceTitre3("Conception d'interfaces graphiques");
        //configurationSite.setBloc1ServiceSoustitre3();

    }
}
