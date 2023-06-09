package com.example.pokedex.network

data class PokemonDetails(
    val order: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<Types>,
    val moves: List<Moves>
    //TODO: Image??
)

class Moves(
    val name: String
)

data class Types(
    val name: String
)
