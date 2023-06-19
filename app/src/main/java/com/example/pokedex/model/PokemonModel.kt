package com.example.pokedex.model

import com.squareup.moshi.Json

data class PokemonModel(
    var name: String,
    val url: String
){
    fun getImageUrl() : String{
        val urlAux = url.substring(0, url.length - 1)
        val index = urlAux.substringAfterLast("/")

        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
    }
    fun getId() : String{
        val urlAux = url.substring(0, url.length - 1)
        return urlAux.substringAfterLast("/")
    }
}
