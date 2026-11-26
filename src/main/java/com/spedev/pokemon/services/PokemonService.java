package com.spedev.pokemon.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spedev.pokemon.models.Pokemon;
import com.spedev.pokemon.repositories.PokemonRepository;


@Service 
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }
}
