package com.saleka.application.configuration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
public final class ConfigurationSite implements Serializable {
    @GeneratedValue(strategy= GenerationType.AUTO )
    @Id
    private long id;
    private String theme;

    //topbar
    private String emailCorp;
    private String telCorp;
    private String sloganCorp;

    //hero section
    private String titrePrincipal;
    private String sousTitrePrincipal;
    private String imagePrincipal;

    //why-us
    private String bloc1WhyusTitre;
    private String bloc1WhyusSousTitre;
    private String bloc2WhyusBoite1Titre;
    private String bloc2WhyusBoite1SousTitre;
    private String bloc2WhyusBoite2Titre;
    private String bloc2WhyusBoite2SousTitre;
    private String bloc2WhyusBoite3Titre;
    private String bloc2WhyusBoite3SousTitre;

    //about
    private String bloc1AboutVideo;
    private String bloc2AboutTitre1;
    private String bloc2AboutTitre2;
    private String bloc2AboutSousTitre2;

    //clients
    private static Collection<String> getclientImage(Collection<String> images){return images;};



}
