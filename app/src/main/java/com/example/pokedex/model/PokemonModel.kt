package com.example.pokedex.model

data class PokemonModel(
    val name: String,
    val url: String
){
    fun getImageUrl() : String{
        val urlAux = url.substring(0, url.length - 1)
        val index = urlAux.substringAfterLast("/")

        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
    }
}
