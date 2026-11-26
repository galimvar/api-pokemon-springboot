package com.spedev.pokemon.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spedev.pokemon.models.Pokemon;
import com.spedev.pokemon.models.PokemonDetail;
import com.spedev.pokemon.services.PokemonService;

@RestController 
public class PokemonDetailController {
    private PokemonService service;

    public PokemonDetailController(PokemonService service){
        this.service = service;
    }

    @GetMapping ("/pokemonwithdetail")
    public Map<String, List<PokemonDetail>> pokemondetails(@RequestParam (required = false) String name, @RequestParam (required = false) String type){
        List<Pokemon> pokemons = new ArrayList<>();

        if (name != null && type == null) {
            pokemons = service.findByName(name);
        } else if (name == null && type != null) {
             pokemons = service.findByType(type);
        } else if (name != null && type != null) {
             pokemons = service.findByNameAndType(name, type);
        } else {
            pokemons = service.findAll();
        }

        return Map.of("status", service.withDetails(pokemons));
    }
}
