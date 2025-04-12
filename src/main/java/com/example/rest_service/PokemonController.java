package com.example.rest_service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // HTTP requests are handled here, from the @RestController
@RequestMapping("/pokemon") // Lowest hierarchy of our URL, for example functions with annotations @GetMapping will be called automatically given that the URL was /pokemon
public class PokemonController {
    
    private final PokemonRepo pokemonRepo; // Initalize our repository
    
    public PokemonController(PokemonRepo pokemonRepo) {
        this.pokemonRepo = pokemonRepo;
    }

    @GetMapping
    public List<Pokemon> getPokemon() {
        return pokemonRepo.findAll(); // Returns the full repo, in JSON (Note: that the return value of this func is List<Pokemon> with no ID's, this is because each Pokemon object has an ID we can use, they are independent)
    }

    @GetMapping("/{id}") // Function will be called when the GET request is pokemon/{id}
    public Pokemon getPokemon(@PathVariable Long id) { // PathVariable annotation is perfect for this case since we can use the given ID of the GET request and use it as a parameter 
        return pokemonRepo.findById(id).orElseThrow(RuntimeException::new); // new RuntimeException() since it expects a supplier 
    }

    @PostMapping // Instead of receiving requests from the server this will do the opposite, this POST request would be in the form of a button and not a URL like GET
    public ResponseEntity createPokemon(@RequestBody Pokemon pokemon) throws URISyntaxException {   
        Pokemon savedPokemon = pokemonRepo.save(pokemon);
        return ResponseEntity.created(new URI("/pokemon/" + savedPokemon.getID())).body(savedPokemon); // Create a new relative URL (URI) and sends the Pokemon as JSON via .body method
    }

    @PutMapping("/{id}") // Responsible for updating data, must require full information not partial
    public ResponseEntity updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        Pokemon currentPokemon = pokemonRepo.findById(id).orElseThrow(RuntimeException::new);
        currentPokemon.setName(pokemon.getName());
        currentPokemon.setType(pokemon.getType());

        return ResponseEntity.ok(currentPokemon); // Tells server that it was successful and returns the new Pokemon
    }

    @DeleteMapping("/{id}") // Resposnible for deleting data
    public ResponseEntity deletePokemon(@PathVariable Long id) {
        pokemonRepo.deleteById(id);
        return ResponseEntity.ok().build(); // Tells the server that it was successful, doesn't return the Pokemon
    }

}