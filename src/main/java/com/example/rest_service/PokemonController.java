package com.example.rest_service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController // HTTP requests are handled here, from the @RestController
@RequestMapping("/pokemon")
public class PokemonController {
    
    private final PokemonRepo pokemonRepo;
    
    public PokemonController(PokemonRepo pokemonRepo) {
        this.pokemonRepo = pokemonRepo;
    }

    @GetMapping
    public List<Pokemon> getPokemon() {
        return pokemonRepo.findAll();
    }

    @GetMapping("/{id}")
    public Pokemon getPokemon(@PathVariable Long id) {
        return pokemonRepo.findById(id).orElseThrow(RuntimeException::new); // new RuntimeException() since it expects a supplier 
    }

    @PostMapping
    public ResponseEntity createPokemon(@RequestBody Pokemon pokemon) throws URISyntaxException {
        Pokemon savedPokemon = pokemonRepo.save(pokemon);
        return ResponseEntity.created(new URI("/pokemon/" + savedPokemon.getID())).body(savedPokemon);
    }

    @PutMapping("/{id}")
    public Pokemon updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        Pokemon currentPokemon = pokemonRepo.findById(id).orElseThrow(RuntimeException::new);
        currentPokemon.setName(pokemon.getName());
        currentPokemon.setType(pokemon.getType());

        return ResponseEntity.ok(currentPokemon);
    }

}