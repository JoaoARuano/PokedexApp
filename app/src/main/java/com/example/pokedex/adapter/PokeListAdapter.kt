package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.databinding.GridViewPokeBinding
import com.example.pokedex.model.PokemonModel

class PokeListAdapter : RecyclerView.Adapter<PokeListAdapter.PokeViewHolder>() {

    //var pokemonList = ArrayList<PokemonModel>()
    var pokemonList: List<PokemonModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokeViewHolder {
        val withDataBinding: GridViewPokeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            PokeViewHolder.LAYOUT,
            parent,
            false
        )
        return PokeViewHolder(withDataBinding)
    }

    override fun getItemCount() = pokemonList.size

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        holder.binding.also {
            it.pokemon = pokemonList[position]
        }
        /*val pokemon = getItem(position)
        holder.bind(pokemon)*/
    }

    class PokeViewHolder(val binding: GridViewPokeBinding):
        RecyclerView.ViewHolder(binding.root){
        companion object{
            @LayoutRes
            val LAYOUT = R.layout.grid_view_poke
        }
            fun bind(pokemon: PokemonModel){
                binding.apply {
                    pokeDesc.text = pokemon.name
                    executePendingBindings()
                }
            }
    }
}