package com.spedev.pokemon.models;

public class Type {
    private String nom;
    private String description;

    public Type(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }
    public String getNom() {
        return nom;
    }
    public String getDescription() {
        return description;
    }
}
