package com.example.pokeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    @Autowired
    private RestTemplate restTemplate;

    // Método que consulta la PokéAPI externa usando el nombre o ID recibido
    public Pokemon obtenerPokemon(String nombreOId) {
        // Convertimos a minúsculas porque la PokéAPI requiere nombres en minúscula (ej: "pikachu")
        String url = "https://pokeapi.co/api/v2/pokemon/" + nombreOId.toLowerCase().trim();

        try {
            // RestTemplate llama a la URL y convierte la respuesta JSON en un objeto de nuestra clase Pokemon
            return restTemplate.getForObject(url, Pokemon.class);
        } catch (Exception e) {
            // Si el Pokémon no existe o falla la conexión, retornamos null
            return null;
        }
    }
}