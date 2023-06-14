package com.example.pokedex.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemon: List<PokemonEntity>)

    @Query("SELECT * FROM pokemons")
    fun getAllPokemons(): LiveData<List<PokemonEntity>>

}