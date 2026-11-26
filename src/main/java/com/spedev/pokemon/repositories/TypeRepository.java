package com.spedev.pokemon.repositories;

import com.spedev.pokemon.models.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeRepository {
    private final List<Type> types = List.of(
            new Type("Electric", "maîtrise l'électricité, souvent rapide"),
            new Type("Feu", "crache des flammes, à l'aise dans la chaleur"),
            new Type("Eau", "vit près de l'eau, et s'en sert pour attaquer"),
            new Type("Plante", "tire sa force des végétaux et du soleil"),
            new Type("Normal", "sans élément particulier, polyvalent")
    );

    public List<Type> findAll() {
        return types;
    }

}
