package com.spedev.pokemon.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spedev.pokemon.models.Type;
import com.spedev.pokemon.services.TypeService;

@RestController
public class TypeController {
    private final TypeService service;

    public TypeController(TypeService service) {
        this.service = service;
    }

    // types?nom=eau
    // types?desc=flammes
    @GetMapping("/types")
    public Map<String, List<Type>> types(@RequestParam(required = false) String nom,
            @RequestParam(required = false) String description) {
        if (nom != null && description == null) {
            return Map.of("status", service.findByName(nom));
        } else if (nom == null && description != null) {
            return Map.of("status", service.findByDescription(description));
        } else if (nom != null && description != null) {
            return Map.of("status", service.findByNameAndDescription(nom, description));
        }
        return Map.of("status", service.findAll());
    }
}