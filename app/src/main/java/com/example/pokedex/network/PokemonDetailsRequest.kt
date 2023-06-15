package com.example.pokedex.network

import com.example.pokedex.database.PokemonDetailEntity
import com.example.pokedex.model.Moves
import com.example.pokedex.model.PokemonDetailModel
import com.example.pokedex.model.Types

data class PokemonDetailsRequest(
    val order: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<Types>,
    val moves: List<Moves>
)


/*fun List<PokemonDetailsRequest>.asDomainModel(): List<PokemonDetailModel> {
    return map {
        PokemonDetailModel(
            order = it.order,
            name = it.name,
            height = it.height,
            weight = it.weight,
            types = it.types,
            moves = it.moves
        )
    }
}

fun List<PokemonDetailsRequest>.asDatabaseModel(): List<PokemonDetailEntity> {
    return map {
        PokemonDetailEntity(
            order = it.order,
            name = it.name,
            height = it.height,
            weight = it.weight,
            types = it.types,
            moves = it.moves
        )
    }
}*/
