package com.spedev.pokemon.models;

import java.util.List;

public class Pokemon {
    private String nom;
    private String type;
    private String cri;
    private List<String> attaques;

    
    public Pokemon(String nom, String type, String cri, List<String> attaques) {
        this.nom = nom;
        this.type = type;
        this.cri = cri;
        this.attaques = attaques;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getCri() {
        return cri;
    }


    public void setCri(String cri) {
        this.cri = cri;
    }


    public List<String> getAttaques() {
        return attaques;
    }


    public void setAttaques(List<String> attaques) {
        this.attaques = attaques;
    }

    
}
