package com.example.pokedex.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pokedex.database.getDatabase
import com.example.pokedex.model.PokemonModel
import com.example.pokedex.repository.PokeRepository
import kotlinx.coroutines.launch

class PokeListViewModel(application: Application) : AndroidViewModel(application) {

    private val pokeRepository = PokeRepository(getDatabase(application))

    val pokemons = pokeRepository.pokemons

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            try {
                pokeRepository.refreshPokemon()
            } catch (e: Exception) {
                //TODO: Error
                if(pokemons.value.isNullOrEmpty())
                    e.printStackTrace()
            }
        }
    }

    fun displayPokemonDetails(pokemonModel: PokemonModel){
        //TODO open Pokemon Detail
    }
}