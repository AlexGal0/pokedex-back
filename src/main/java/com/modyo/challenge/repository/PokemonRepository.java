package com.modyo.challenge.repository;

import com.modyo.challenge.entities.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Repository
public class PokemonRepository {

    @Autowired
    private RestTemplate restTemplate;
    public Logger logger = LoggerFactory.getLogger(PokemonRepository.class);

    @Value("${pokemon-api.pokemon}")
    private String pokemonApiUri;

    public Optional<Pokemon> getPokemonById(Integer id) {
        logger.debug(pokemonApiUri);
        ResponseEntity<Pokemon> pokemon = null;
        try {
            pokemon = restTemplate.getForEntity(pokemonApiUri + "{id}", Pokemon.class, id);
        } catch (HttpStatusCodeException ex) {
            if (ex.getStatusCode() != HttpStatus.OK)
                return Optional.empty();
        }

        return Optional.ofNullable(pokemon.getBody());
    }

}
