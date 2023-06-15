package com.example.pokedex.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface PokemonDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemon: PokemonDetailEntity)
}