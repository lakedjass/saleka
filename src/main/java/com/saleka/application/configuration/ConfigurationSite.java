package com.saleka.application.configuration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class ConfigurationSite implements Serializable {
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
    private  String bloc3AboutTitre1;
    private String bloc3AboutSousTitre1;
    private  String bloc3AboutTitre2;
    private String bloc3AboutSousTitre2;
    private  String bloc3AboutTitre3;
    private String bloc3AboutSousTitre3;

    //Services
    private String titreService;
    private String descriptionService;
    private String bloc1ServiceTitre1;
    private String bloc1ServiceSoustitre1;
    private String bloc1ServiceTitre2;
    private String bloc1ServiceSoustitre2;
    private String bloc1ServiceTitre3;
    private String bloc1ServiceSoustitre3;
    private String bloc2ServiceTitre1;
    private String bloc2ServiceSoustitre1;
    private String bloc2ServiceTitre2;
    private String bloc2ServiceSoustitre2;
    private String bloc2ServiceTitre3;
    private String bloc2ServiceSoustitre3;

    // Our
    private String ourMissionTitre;
    private String ourMissionDescription;
    private String ourPlanTitre;
    private String ourPlanDescription;
    private String ourVisionTitre;
    private String ourVisionDescription;
    private String ourCareTitre;
    private String ourCareDescription;

    // Contact
    private String contactDescription;
    private String adresse;

    //newsletter
    private String newsletterDescription;

    //clients
    private Collection<String> getclientImage(Collection<String> images){return images;};

    public String getEmailCorp() {
        return emailCorp;
    }

    public void setEmailCorp(String emailCorp) {
        this.emailCorp = emailCorp;
    }

    public String getTelCorp() {
        return telCorp;
    }

    public void setTelCorp(String telCorp) {
        this.telCorp = telCorp;
    }

    public String getSloganCorp() {
        return sloganCorp;
    }

    public void setSloganCorp(String sloganCorp) {
        this.sloganCorp = sloganCorp;
    }

    public String getTitrePrincipal() {
        return titrePrincipal;
    }

    public void setTitrePrincipal(String titrePrincipal) {
        this.titrePrincipal = titrePrincipal;
    }

    public String getSousTitrePrincipal() {
        return sousTitrePrincipal;
    }

    public void setSousTitrePrincipal(String sousTitrePrincipal) {
        this.sousTitrePrincipal = sousTitrePrincipal;
    }

    public String getImagePrincipal() {
        return imagePrincipal;
    }

    public void setImagePrincipal(String imagePrincipal) {
        this.imagePrincipal = imagePrincipal;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getBloc1WhyusTitre() {
        return bloc1WhyusTitre;
    }

    public void setBloc1WhyusTitre(String bloc1WhyusTitre) {
        this.bloc1WhyusTitre = bloc1WhyusTitre;
    }

    public String getBloc1WhyusSousTitre() {
        return bloc1WhyusSousTitre;
    }

    public void setBloc1WhyusSousTitre(String bloc1WhyusSousTitre) {
        this.bloc1WhyusSousTitre = bloc1WhyusSousTitre;
    }

    public String getBloc2WhyusBoite1Titre() {
        return bloc2WhyusBoite1Titre;
    }

    public void setBloc2WhyusBoite1Titre(String bloc2WhyusBoite1Titre) {
        this.bloc2WhyusBoite1Titre = bloc2WhyusBoite1Titre;
    }

    public String getBloc2WhyusBoite1SousTitre() {
        return bloc2WhyusBoite1SousTitre;
    }

    public void setBloc2WhyusBoite1SousTitre(String bloc2WhyusBoite1SousTitre) {
        this.bloc2WhyusBoite1SousTitre = bloc2WhyusBoite1SousTitre;
    }

    public String getBloc2WhyusBoite2Titre() {
        return bloc2WhyusBoite2Titre;
    }

    public void setBloc2WhyusBoite2Titre(String bloc2WhyusBoite2Titre) {
        this.bloc2WhyusBoite2Titre = bloc2WhyusBoite2Titre;
    }

    public String getBloc2WhyusBoite2SousTitre() {
        return bloc2WhyusBoite2SousTitre;
    }

    public void setBloc2WhyusBoite2SousTitre(String bloc2WhyusBoite2SousTitre) {
        this.bloc2WhyusBoite2SousTitre = bloc2WhyusBoite2SousTitre;
    }

    public String getBloc2WhyusBoite3Titre() {
        return bloc2WhyusBoite3Titre;
    }

    public void setBloc2WhyusBoite3Titre(String bloc2WhyusBoite3Titre) {
        this.bloc2WhyusBoite3Titre = bloc2WhyusBoite3Titre;
    }

    public String getBloc2WhyusBoite3SousTitre() {
        return bloc2WhyusBoite3SousTitre;
    }

    public void setBloc2WhyusBoite3SousTitre(String bloc2WhyusBoite3SousTitre) {
        this.bloc2WhyusBoite3SousTitre = bloc2WhyusBoite3SousTitre;
    }

    public String getBloc1AboutVideo() {
        return bloc1AboutVideo;
    }

    public void setBloc1AboutVideo(String bloc1AboutVideo) {
        this.bloc1AboutVideo = bloc1AboutVideo;
    }

    public String getBloc2AboutTitre1() {
        return bloc2AboutTitre1;
    }

    public void setBloc2AboutTitre1(String bloc2AboutTitre1) {
        this.bloc2AboutTitre1 = bloc2AboutTitre1;
    }

    public String getBloc2AboutTitre2() {
        return bloc2AboutTitre2;
    }

    public void setBloc2AboutTitre2(String bloc2AboutTitre2) {
        this.bloc2AboutTitre2 = bloc2AboutTitre2;
    }

    public String getBloc2AboutSousTitre2() {
        return bloc2AboutSousTitre2;
    }

    public void setBloc2AboutSousTitre2(String bloc2AboutSousTitre2) {
        this.bloc2AboutSousTitre2 = bloc2AboutSousTitre2;
    }

    public String getBloc3AboutTitre1() {
        return bloc3AboutTitre1;
    }

    public void setBloc3AboutTitre1(String bloc3AboutTitre1) {
        this.bloc3AboutTitre1 = bloc3AboutTitre1;
    }

    public String getBloc3AboutSousTitre1() {
        return bloc3AboutSousTitre1;
    }

    public void setBloc3AboutSousTitre1(String getBloc3AboutSousTitre1) {
        this.bloc3AboutSousTitre1 = getBloc3AboutSousTitre1;
    }

    public String getBloc3AboutTitre2() {
        return bloc3AboutTitre2;
    }

    public void setBloc3AboutTitre2(String bloc3AboutTitre2) {
        this.bloc3AboutTitre2 = bloc3AboutTitre2;
    }

    public String getBloc3AboutSousTitre2() {
        return bloc3AboutSousTitre2;
    }

    public void setBloc3AboutSousTitre2(String getBloc3AboutSousTitre2) {
        this.bloc3AboutSousTitre2 = getBloc3AboutSousTitre2;
    }

    public String getBloc3AboutTitre3() {
        return bloc3AboutTitre3;
    }

    public void setBloc3AboutTitre3(String bloc3AboutTitre3) {
        this.bloc3AboutTitre3 = bloc3AboutTitre3;
    }

    public String getBloc3AboutSousTitre3() {
        return bloc3AboutSousTitre3;
    }

    public void setBloc3AboutSousTitre3(String getBloc3AboutSousTitre3) {
        this.bloc3AboutSousTitre3 = getBloc3AboutSousTitre3;
    }

    public String getTitreService() {
        return titreService;
    }

    public void setTitreService(String titreService) {
        this.titreService = titreService;
    }

    public String getDescriptionService() {
        return descriptionService;
    }

    public void setDescriptionService(String descriptionService) {
        this.descriptionService = descriptionService;
    }

    public String getBloc1ServiceTitre1() {
        return bloc1ServiceTitre1;
    }

    public void setBloc1ServiceTitre1(String bloc1ServiceTitre1) {
        this.bloc1ServiceTitre1 = bloc1ServiceTitre1;
    }

    public String getBloc1ServiceSoustitre1() {
        return bloc1ServiceSoustitre1;
    }

    public void setBloc1ServiceSoustitre1(String bloc1ServiceSoustitre) {
        this.bloc1ServiceSoustitre1 = bloc1ServiceSoustitre;
    }

    public String getBloc1ServiceTitre2() {
        return bloc1ServiceTitre2;
    }

    public void setBloc1ServiceTitre2(String bloc1ServiceTitre2) {
        this.bloc1ServiceTitre2 = bloc1ServiceTitre2;
    }

    public String getBloc1ServiceSoustitre2() {
        return bloc1ServiceSoustitre2;
    }

    public void setBloc1ServiceSoustitre2(String bloc1ServiceSoustitre2) {
        this.bloc1ServiceSoustitre2 = bloc1ServiceSoustitre2;
    }

    public String getBloc1ServiceTitre3() {
        return bloc1ServiceTitre3;
    }

    public void setBloc1ServiceTitre3(String bloc1ServiceTitre3) {
        this.bloc1ServiceTitre3 = bloc1ServiceTitre3;
    }

    public String getBloc1ServiceSoustitre3() {
        return bloc1ServiceSoustitre3;
    }

    public void setBloc1ServiceSoustitre3(String bloc1ServiceSoustitre3) {
        this.bloc1ServiceSoustitre3 = bloc1ServiceSoustitre3;
    }

    public String getBloc2ServiceTitre1() {
        return bloc2ServiceTitre1;
    }

    public void setBloc2ServiceTitre1(String bloc2ServiceTitre1) {
        this.bloc2ServiceTitre1 = bloc2ServiceTitre1;
    }

    public String getBloc2ServiceSoustitre1() {
        return bloc2ServiceSoustitre1;
    }

    public void setBloc2ServiceSoustitre1(String bloc2ServiceSoustitre1) {
        this.bloc2ServiceSoustitre1 = bloc2ServiceSoustitre1;
    }

    public String getBloc2ServiceTitre2() {
        return bloc2ServiceTitre2;
    }

    public void setBloc2ServiceTitre2(String bloc2ServiceTitre2) {
        this.bloc2ServiceTitre2 = bloc2ServiceTitre2;
    }

    public String getBloc2ServiceSoustitre2() {
        return bloc2ServiceSoustitre2;
    }

    public void setBloc2ServiceSoustitre2(String bloc2ServiceSoustitre2) {
        this.bloc2ServiceSoustitre2 = bloc2ServiceSoustitre2;
    }

    public String getBloc2ServiceTitre3() {
        return bloc2ServiceTitre3;
    }

    public void setBloc2ServiceTitre3(String bloc2ServiceTitre3) {
        this.bloc2ServiceTitre3 = bloc2ServiceTitre3;
    }

    public String getBloc2ServiceSoustitre3() {
        return bloc2ServiceSoustitre3;
    }

    public void setBloc2ServiceSoustitre3(String bloc2ServiceSoustitre3) {
        this.bloc2ServiceSoustitre3 = bloc2ServiceSoustitre3;
    }

    public String getOurMissionTitre() {
        return ourMissionTitre;
    }

    public void setOurMissionTitre(String ourMissionTitre) {
        this.ourMissionTitre = ourMissionTitre;
    }

    public String getOurMissionDescription() {
        return ourMissionDescription;
    }

    public void setOurMissionDescription(String ourMissionDescription) {
        this.ourMissionDescription = ourMissionDescription;
    }

    public String getOurPlanTitre() {
        return ourPlanTitre;
    }

    public void setOurPlanTitre(String ourPlanTitre) {
        this.ourPlanTitre = ourPlanTitre;
    }

    public String getOurPlanDescription() {
        return ourPlanDescription;
    }

    public void setOurPlanDescription(String ourPlanDescription) {
        this.ourPlanDescription = ourPlanDescription;
    }

    public String getOurVisionTitre() {
        return ourVisionTitre;
    }

    public void setOurVisionTitre(String ourVisionTitre) {
        this.ourVisionTitre = ourVisionTitre;
    }

    public String getOurVisionDescription() {
        return ourVisionDescription;
    }

    public void setOurVisionDescription(String ourVisionDescription) {
        this.ourVisionDescription = ourVisionDescription;
    }

    public String getOurCareTitre() {
        return ourCareTitre;
    }

    public void setOurCareTitre(String ourCareTitre) {
        this.ourCareTitre = ourCareTitre;
    }

    public String getOurCareDescription() {
        return ourCareDescription;
    }

    public void setOurCareDescription(String ourCareDescription) {
        this.ourCareDescription = ourCareDescription;
    }

    public String getContactDescription() {
        return contactDescription;
    }

    public void setContactDescription(String contactDescription) {
        this.contactDescription = contactDescription;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNewsletterDescription() {
        return newsletterDescription;
    }

    public void setNewsletterDescription(String newsletterDescription) {
        this.newsletterDescription = newsletterDescription;
    }
}
