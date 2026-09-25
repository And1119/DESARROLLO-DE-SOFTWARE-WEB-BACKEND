package com.example.pokeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    // Ruta principal: Muestra la vista con el formulario de búsqueda
    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    // Ruta para buscar desde la barra de búsqueda del formulario web
    @GetMapping("/buscar")
    public String buscarPokemon(@RequestParam(name = "nombre", required = false) String nombre, Model model) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            Pokemon pokemon = pokemonService.obtenerPokemon(nombre);
            if (pokemon != null) {
                model.addAttribute("pokemon", pokemon);
            } else {
                model.addAttribute("error", "No se encontró el Pokémon: " + nombre);
            }
        }
        model.addAttribute("nombreBusqueda", nombre);
        return "index";
    }

    // Ruta opcional para buscar directamente por URL (ej: /pokemon/25 o /pokemon/pikachu)
    @GetMapping("/pokemon/{nombreOId}")
    public String buscarPorUrl(@PathVariable String nombreOId, Model model) {
        Pokemon pokemon = pokemonService.obtenerPokemon(nombreOId);
        if (pokemon != null) {
            model.addAttribute("pokemon", pokemon);
        } else {
            model.addAttribute("error", "No se encontró el Pokémon: " + nombreOId);
        }
        return "index";
    }
}