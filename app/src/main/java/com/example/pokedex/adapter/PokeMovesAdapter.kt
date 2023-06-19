package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.ContentMainBinding
import com.example.pokedex.databinding.MovesItemViewBinding
import com.example.pokedex.model.PokemonDetailModel

class PokeMovesAdapter: RecyclerView.Adapter<PokeMovesAdapter.MovesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokeMovesAdapter.MovesViewHolder {
        return MovesViewHolder(MovesItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PokeMovesAdapter.MovesViewHolder, position: Int) {
        val pokemonModel = getItemId(position)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class MovesViewHolder(val binding: MovesItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: PokemonDetailModel){
            binding.pokemonDetail = pokemon
        }
    }

}