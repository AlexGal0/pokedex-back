package com.modyo.challenge.controller;

import com.modyo.challenge.entities.Pokemon;
import com.modyo.challenge.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/Hello")
    public String getHello() {
        return "Hello";
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable("id") int pokemonId){
        return pokemonService.getPokemonById(pokemonId)
                .map(pokemon -> new ResponseEntity<>(pokemon, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
