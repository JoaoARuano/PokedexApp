package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.databinding.GridViewPokeBinding
import com.example.pokedex.model.PokemonModel
import kotlinx.coroutines.NonDisposableHandle.parent

class PokeListAdapter(val clickListener: OnClickListener) :
    ListAdapter<PokemonModel, PokeListAdapter.PokeViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokeViewHolder {
        return PokeViewHolder(GridViewPokeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        val pokemonRequest = getItem(position)
        holder.bind(pokemonRequest!!, clickListener)
    }

    class PokeViewHolder(val binding: GridViewPokeBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemonModel: PokemonModel, clickListener: OnClickListener) {
            binding.pokemon = pokemonModel
            binding.clickListener = clickListener
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

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .into(imgView)
    }
}