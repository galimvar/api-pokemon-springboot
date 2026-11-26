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

    public List<Pokemon> findByName(String nom) {
        List<Pokemon> result = new ArrayList<>();
        for (Pokemon pokemon : pokemonRepository.findAll()) {
            if (pokemon.getName().toLowercase().contains(nom.toLowercase())) {
                result.add(pokemon);
            }
        }
        return result;
    }

    public List<Pokemon> findByType(String type) {
                List<Pokemon> result = new ArrayList<>();
        for (Pokemon pokemon : pokemonRepository.findAll()) {
            if (pokemon.getType().toLowercase().contains(type.toLowercase())) {
                result.add(pokemon);
            }
        }
        return result;
    }

    public List<Pokemon> findByNameAndType(String nom, String type) {
        List<Pokemon> result = new ArrayList<>();
                for (Pokemon pokemon : pokemonRepository.findAll()) {
            if (pokemon.getName().toLowerCase().contains(nom.toLowerCase()) && pokemon.getType().contains(type.toLowercase())) {
                result.add(pokemon);
            }
        }
        return result;
    }
}
