package com.example.pokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.network.PokeApi
import com.example.pokedex.network.Pokemon
import kotlinx.coroutines.launch

class PokeListViewModel : ViewModel() {

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            try {
                _pokemonList.value = PokeApi.retrofitService.getPokemonList(20, 20).results
            } catch (e: Exception) {
                //TODO: Error
                e.printStackTrace()
            }
        }
    }
}