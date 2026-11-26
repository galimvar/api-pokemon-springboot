package com.spedev.pokemon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spedev.pokemon.models.Type;
import com.spedev.pokemon.repositories.TypeRepository;

@Service
public class TypeService {
    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    public List<Type> findByName(String nom) {
        List<Type> result = new ArrayList<>();
        for (Type type : typeRepository.findAll()) {
            if (type.getNom().toLowerCase().contains(nom.toLowerCase())) {
                result.add(type);
            }
        }
        return result;
    }

    public List<Type> findByDescription(String desc) {
        List<Type> result = new ArrayList<>();
        for (Type type : typeRepository.findAll()) {
            if (type.getDescription().toLowerCase().contains(desc.toLowerCase())) {
                result.add(type);
            }
        }
        return result;
    }

    public List<Type> findByNameAndDescription(String nom, String desc) {
        List<Type> result = new ArrayList<>();
        for (Type type : typeRepository.findAll()) {
            if (type.getNom().toLowerCase().contains(nom.toLowerCase()) && type.getDescription().toLowerCase().contains(desc.toLowerCase())) {
                result.add(type);
            }
        }
        return result;
    }
}
