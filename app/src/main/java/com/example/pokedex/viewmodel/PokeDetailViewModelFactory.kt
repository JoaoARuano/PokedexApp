package com.example.pokedex.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.model.PokemonModel
import java.lang.IllegalArgumentException

class PokeDetailViewModelFactory(
    private val pokemonId: String,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokeDetailViewModel::class.java)) {
            return PokeDetailViewModel(pokemonId, application) as T
        }
        throw IllegalArgumentException("Unknown")
    }
}