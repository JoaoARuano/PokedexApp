package com.example.pokedex.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.model.PokemonModel


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<PokemonModel>?) {
    val adapter = recyclerView.adapter as PokeListAdapter
    adapter.submitList(data)
}
