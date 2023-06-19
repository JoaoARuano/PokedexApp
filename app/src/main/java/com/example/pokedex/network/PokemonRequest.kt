package com.example.pokedex.network

import com.example.pokedex.model.PokemonModel

data class PokemonRequest(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonModel>
)
