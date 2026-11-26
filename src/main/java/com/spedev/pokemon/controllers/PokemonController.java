package com.spedev.pokemon.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spedev.pokemon.models.Pokemon;
import com.spedev.pokemon.services.PokemonService;

@RestController 
public class PokemonController {
    private PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    // pokemon?name=pikachu
    // pokemon?type=electrique
    @GetMapping ("/pokemon")
    public Map<String, List<Pokemon>> pokemon(  @RequestParam (required = false) String name, @RequestParam (required = false) String type, @RequestParam (required = false) String attaque ){
        
        if (name != null && type == null) {
            return Map.of("status", service.findByName(name));
        } else if (name == null && type != null) {
            return Map.of("status", service.findByType(type));
        } else if (name != null && type != null) {
            return Map.of("status", service.findByNameAndType(name, type));
        }
        
        return Map.of("status", service.findAll());  
        
    }
}
