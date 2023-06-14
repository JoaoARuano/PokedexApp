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
        val activity = requireNotNull(this.activity) {

        }
        ViewModelProvider(this, PokeListViewModel.Factory(activity.application))
            .get(PokeListViewModel::class.java)
    }

    private var pokeListAdapter: PokeListAdapter? = null

/*    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentFirstBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_first,
            container,
            false
        )

        //_binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        binding.lifecycleOwner = this

        binding.viewmodel = viewModel

        binding.root.findViewById<RecyclerView>(R.id.poke_grid).apply {
            adapter = pokeListAdapter
        }

        //binding.pokeGrid.adapter = pokeListAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemons.observe(viewLifecycleOwner, Observer { pokemons ->
            pokemons?.apply {
                pokeListAdapter?.pokemonList = pokemons as ArrayList<PokemonModel>
            }
        })
        /*binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //_binding = null
    }
}