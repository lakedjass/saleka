package com.saleka.application.configuration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Configuration implements Serializable {
    @GeneratedValue
    @Id
    private long id;
    private String logo;
    private String theme;

    public Configuration() {
    }

    public Configuration(String logo, String theme) {
        this.logo = logo;
        this.theme = theme;
    }

    public Configuration(long id, String logo, String theme) {
        this.id = id;
        this.logo = logo;
        this.theme = theme;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "id=" + id +
                ", logo='" + logo + '\'' +
                ", theme='" + theme + '\'' +
                '}';
    }
}
