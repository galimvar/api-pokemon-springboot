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

    @GetMapping ("/pokemon")
    public Map<String, List<Pokemon>> pokemon(  @RequestParam (required = false) String name,
                                                @RequestParam (required = false) String type,
                                                @RequestParam (required = false) String attaque ){
        return Map.of("status", service.findAll());                                                
    }
}
