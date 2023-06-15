package com.example.pokedex.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.pokedex.database.PokemonDatabase
import com.example.pokedex.database.asDomainModel
import com.example.pokedex.model.PokemonModel
import com.example.pokedex.network.PokeApi
import com.example.pokedex.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokeRepository(private val db: PokemonDatabase) {

    val pokemons: LiveData<List<PokemonModel>> = db.getPokemonDao().getAllPokemons().map {
        it.asDomainModel()
    }

    suspend fun refreshPokemon() {
        withContext(Dispatchers.IO){
            val pokemonRequest = PokeApi.retrofitService.getPokemonList(1, 20)
            db.getPokemonDao().insert(pokemonRequest.results.asDatabaseModel())
        }
    }

}