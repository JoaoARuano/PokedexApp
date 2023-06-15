package com.example.pokedex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.adapter.PokeListAdapter
import com.example.pokedex.databinding.FragmentFirstBinding
import com.example.pokedex.databinding.FragmentSecondBinding
import com.example.pokedex.model.PokemonModel
import com.example.pokedex.viewmodel.PokeListViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val viewModel: PokeListViewModel by lazy {
        ViewModelProvider(this)
            .get(PokeListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFirstBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        val viewModel = viewModel

        binding.pokeGrid.adapter = PokeListAdapter(PokeListAdapter.OnClickListener{
            viewModel.displayPokemonDetails(it)
        })


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
    }
}