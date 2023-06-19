package com.example.pokedex

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
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
import com.example.pokedex.network.PokeApi
import com.example.pokedex.viewmodel.PokeListViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val TAG: String = FirstFragment::class.java.simpleName

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PokeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        val adapter = PokeListAdapter(PokeListAdapter.OnClickListener {
            viewModel.displayPokemonDetails(it)
        })

        binding.pokeGrid.adapter = adapter

        binding.pokeGrid

        viewModel.pokemonList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
                Log.d(TAG, "List size frag: " + it.size.toString())
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.navigateToSelectedPokemon.observe(viewLifecycleOwner, Observer {
            if (null != it){
                //this.findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(it))
                this.findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(it.getId()))
            }
        })
    }
}