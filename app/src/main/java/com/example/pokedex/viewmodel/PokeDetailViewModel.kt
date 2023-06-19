package com.example.pokedex.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.example.pokedex.MainActivity
import com.example.pokedex.model.PokemonDetailModel
import com.example.pokedex.model.PokemonModel
import com.example.pokedex.network.PokeApi
import kotlinx.coroutines.launch

class PokeDetailViewModel(pokemonId: String, application: Application) : AndroidViewModel(application) {

    private val TAG: String = PokeDetailViewModel::class.java.simpleName

    private val _pokemonDetail = MutableLiveData<PokemonDetailModel>()
    val pokemonDetail: LiveData<PokemonDetailModel> = _pokemonDetail

    val id: String = pokemonId

    init {
        getPokemonDetail(pokemonId)
    }

    private fun getPokemonDetail(id: String) {
        viewModelScope.launch {
            try {
                _pokemonDetail.value = PokeApi.retrofitService.getPokemon(id)
                Log.d(TAG, "Pokemon Detail " + _pokemonDetail.value!!.toString())
            } catch (e: Exception) {
                //TODO: Error
                e.printStackTrace()
            }
        }
    }

}