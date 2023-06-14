package com.example.pokedex.model

data class PokemonDetailModel(
    val order: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<Types>,
    val moves: List<Moves>
    //TODO: Image??
)

data class Moves(
    val name: String
)

data class Types(
    val name: String
)
