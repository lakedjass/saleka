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
}
