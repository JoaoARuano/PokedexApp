package com.example.pokedex.model

data class PokemonDetailModel(
    val order: Int,
    val name: String,
    val height: Int,
    val weight: Int
   /* val types: List<Types>,
    val moves: List<Moves>*/
) {
    fun getImageUrl() : String{
        val id = order-1
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    }
}

data class Moves(
    val move: String
)

data class Types(
    val name: String
)
