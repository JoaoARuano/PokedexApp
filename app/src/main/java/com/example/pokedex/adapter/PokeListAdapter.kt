package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.GridViewPokeBinding
import com.example.pokedex.model.PokemonModel

class PokeListAdapter() :
    ListAdapter<PokemonModel, PokeListAdapter.PokeViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokeViewHolder {
        return PokeViewHolder(GridViewPokeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        val pokemonRequest = getItem(position)
        holder.itemView.setOnClickListener {
            //onClickListener.onClick(pokemonRequest)
        }
        holder.bind(pokemonRequest)
    }

    class PokeViewHolder(val binding: GridViewPokeBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemonModel: PokemonModel) {
            binding.pokemon = pokemonModel
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PokemonModel>() {
        override fun areItemsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean {
            return oldItem.name == newItem.name
        }
    }

    class OnClickListener(val clickListener: (pokemonModel: PokemonModel) -> Unit) {
        fun onClick(pokemonModel: PokemonModel) = clickListener(pokemonModel)
    }
}