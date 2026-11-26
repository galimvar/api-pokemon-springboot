package com.spedev.pokemon.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spedev.pokemon.models.Type;
import com.spedev.pokemon.repositories.TypeRepository;

@RestController
public class TypeController {
    private final TypeRepository repository;

    public TypeController(TypeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/types")
    public List<Type> types() {
        return repository.findAll();
    }
}