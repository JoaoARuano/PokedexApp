package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.GridViewPokeBinding
import com.example.pokedex.network.Pokemon

class PokeListAdapter : ListAdapter<ArrayList<Pokemon>, PokeListAdapter.PokeViewHolder>(DiffCallback) {

    private val pokemonList = ArrayList<Pokemon>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokeListAdapter.PokeViewHolder {
        return PokeViewHolder(GridViewPokeBinding.inflate(
            LayoutInflater.from(parent.context)
        ))
    }

    override fun onBindViewHolder(holder: PokeListAdapter.PokeViewHolder, position: Int) {
        holder.bind(pokemonList[position])
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ArrayList<Pokemon>>() {
        override fun areItemsTheSame(oldItem: ArrayList<Pokemon>, newItem: ArrayList<Pokemon>): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: ArrayList<Pokemon>, newItem: ArrayList<Pokemon>): Boolean {
            TODO("Not yet implemented")
        }
    }

    class PokeViewHolder(private var binding: GridViewPokeBinding):
        RecyclerView.ViewHolder(binding.root){
            fun bind(pokemon: Pokemon){
                binding.apply {
                    pokeDesc.text = pokemon.name
                }
            }
    }


}