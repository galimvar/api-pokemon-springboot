package com.spedev.pokemon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spedev.pokemon.models.Pokemon;
import com.spedev.pokemon.models.PokemonDetail;
import com.spedev.pokemon.models.Type;
import com.spedev.pokemon.repositories.PokemonRepository;


@Service 
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final TypeService service;

    public PokemonService(PokemonRepository pokemonRepository, TypeService service){
        this.pokemonRepository = pokemonRepository;
        this.service = service;
    }

    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }

    public List<Pokemon> findByName(String nom) {
        List<Pokemon> result = new ArrayList<>();
        for (Pokemon pokemon : pokemonRepository.findAll()) {
            if (pokemon.getNom().toLowerCase().contains(nom.toLowerCase())) {
                result.add(pokemon);
            }
        }
        return result;
    }

    public List<Pokemon> findByType(String type) {
                List<Pokemon> result = new ArrayList<>();
        for (Pokemon pokemon : pokemonRepository.findAll()) {
            if (pokemon.getType().toLowerCase().contains(type.toLowerCase())) {
                result.add(pokemon);
            }
        }
        return result;
    }

    public List<Pokemon> findByNameAndType(String nom, String type) {
        List<Pokemon> result = new ArrayList<>();
                for (Pokemon pokemon : pokemonRepository.findAll()) {
            if (pokemon.getNom().toLowerCase().contains(nom.toLowerCase()) && pokemon.getType().contains(type.toLowerCase())) {
                result.add(pokemon);
            }
        }
        return result;
    }

    public void create(Pokemon pokemon) {
        pokemonRepository.create(pokemon);
    }
/*
    POUR CHAQUE pokemon FAIRE
        REGARDER son type
        POUR CHAQUE TYPE EXISTANT
            regarder si (le type du pokemon == type existant)
                pokemonDetail ( pokemon , type )


*/
    public List<PokemonDetail> withDetails(List<Pokemon> pokemons) {
        List<PokemonDetail> pokemonsWithDetails = new ArrayList<>();
        for (Pokemon pokemon : pokemons) {
            String typePokemon = pokemon.getType();
            List<Type> types = service.findAll();
            for (Type type : types) {
                if(typePokemon.toLowerCase().equals(type.getNom().toLowerCase()) ){
                    pokemonsWithDetails.add(new PokemonDetail(pokemon, type));
                }
            }
        }

        return pokemonsWithDetails;
    }

    public boolean deletePokemon(String name) {
        List<Pokemon> pokemons = pokemonRepository.findAll();

        for (Pokemon pokemon : pokemons) {
            if(pokemon.getNom().equalsIgnoreCase(name)){
                pokemonRepository.delete(pokemon);
                return true;
            }
        }
        return false;

    }
}
