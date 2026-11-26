package com.spedev.pokemon.models;

import java.util.List;

public class PokemonDetail {
    private final Pokemon pokemon;
    private final Type type;

    public PokemonDetail(Pokemon pokemon, Type type){
        this.pokemon = pokemon;
        this.type = type;
    }

    
    public String getNom() {
        return pokemon.getNom();
    }


    public String getCri() {
        return pokemon.getCri();
    }


    public List<String> getAttaques() {
        return pokemon.getAttaques();
    }

    public String getType() {
        return type.getNom();
    }
    public String getDescription() {
        return type.getDescription();
    }
}
