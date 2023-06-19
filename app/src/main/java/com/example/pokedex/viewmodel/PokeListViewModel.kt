package com.example.pokedex.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedex.MainActivity
import com.example.pokedex.model.PokemonModel
import com.example.pokedex.network.PokeApi
import kotlinx.coroutines.launch

class PokeListViewModel(application: Application) : AndroidViewModel(application) {

    private val TAG: String = MainActivity::class.java.simpleName

    private val _pokemonList = MutableLiveData<List<PokemonModel>>()
    val pokemonList: LiveData<List<PokemonModel>> = _pokemonList

    private val _navigateToSelectedPokemon = MutableLiveData<PokemonModel>()
    val navigateToSelectedPokemon: LiveData<PokemonModel> = _navigateToSelectedPokemon

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            try {
                _pokemonList.value = PokeApi.retrofitService.getPokemonList(1,20).results
                Log.d(TAG, "List size: " + _pokemonList.value!!.size.toString())
            } catch (e: Exception) {
                //TODO: Error
                    e.printStackTrace()
            }
        }
    }

    fun displayPokemonDetails(pokemonModel: PokemonModel){
        _navigateToSelectedPokemon.value = pokemonModel
    }
}