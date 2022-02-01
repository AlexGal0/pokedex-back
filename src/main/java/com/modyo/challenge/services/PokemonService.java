package com.modyo.challenge.services;

import com.modyo.challenge.entities.Pokemon;
import com.modyo.challenge.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public Optional<Pokemon> getPokemonById(Integer id) {
        return pokemonRepository.getPokemonById(id);
    }
}
