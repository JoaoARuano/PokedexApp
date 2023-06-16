package com.example.pokedex.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pokedex.MainActivity
import com.example.pokedex.database.getDatabase
import com.example.pokedex.model.PokemonModel
import com.example.pokedex.network.PokeApi
import com.example.pokedex.repository.PokeRepository
import kotlinx.coroutines.launch

class PokeListViewModel(application: Application) : AndroidViewModel(application) {

    private val TAG: String = MainActivity::class.java.simpleName

    private val _pokemonList = MutableLiveData<List<PokemonModel>>()
    val pokemonList: LiveData<List<PokemonModel>>
        get() = _pokemonList

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            try {
                _pokemonList.value = PokeApi.retrofitService.getPokemonList(1,20).results
                Log.d(TAG, "List size: " + _pokemonList.value!!.size.toString())
                //pokeRepository.refreshPokemon()
            } catch (e: Exception) {
                //TODO: Error
                    e.printStackTrace()
            }
        }
    }

    fun displayPokemonDetails(pokemonModel: PokemonModel){
        //TODO open Pokemon Detail
    }
}