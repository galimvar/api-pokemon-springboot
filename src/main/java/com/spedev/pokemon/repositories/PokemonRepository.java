package com.spedev.pokemon.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spedev.pokemon.models.Pokemon;


@Repository 
public class PokemonRepository {
    private final List<Pokemon> pokemons = new ArrayList<>();
    
    public PokemonRepository(){
        pokemons.add(new Pokemon("Pikachu", "Electrique", "Pika pika !", new ArrayList<String>()));
        pokemons.add(new Pokemon("Salamèche", "Feu", "Sala !", new ArrayList<String>()));
        pokemons.add(new Pokemon("Carapuce", "Eau", "Cara cara !", new ArrayList<String>()));
        pokemons.add(new Pokemon("Bulbizarre", "Plante", "Bulbi !", new ArrayList<String>()));
        pokemons.add(new Pokemon("Evoli", "Normal", "Evoli !", new ArrayList<String>()));
        pokemons.add(new Pokemon("Noctali", "Ténèbres", "Noc !", List.of("Vive attaque", "Morsure", "Ténèbres", "Provoc")));

    }

    public List<Pokemon> findAll() {
        return pokemons;
    }

    public void create(Pokemon pokemon) {
        pokemons.add(pokemon);
    }
}
