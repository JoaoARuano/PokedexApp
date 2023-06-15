package com.example.pokedex.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter


@Entity(tableName = "pokemon_detail")
data class PokemonDetailEntity (
    @PrimaryKey
    val order: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    //TODO: TypeConverter for the list
    //@Embedded val types: List<String>,
    //@Embedded val moves: List<Moves>

    //TODO: Image??
)

data class Moves (
    val name: String
)

data class Types (
    val name: String
)
