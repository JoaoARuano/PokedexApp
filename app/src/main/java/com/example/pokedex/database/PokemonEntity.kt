package com.example.pokedex.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedex.model.PokemonModel

@Entity(tableName = "pokemons")
data class PokemonEntity constructor(
    @PrimaryKey
    val name: String,
    val url: String
)

fun List<PokemonEntity>.asDomainModel(): List<PokemonModel>{
    return map {
        PokemonModel(
            name = it.name,
            url = it.url
        )
    }
}
