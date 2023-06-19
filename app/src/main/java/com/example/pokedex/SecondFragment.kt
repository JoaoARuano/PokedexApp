package com.example.pokedex

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.navigation.fragment.findNavController
import com.example.pokedex.databinding.FragmentSecondBinding
import com.example.pokedex.viewmodel.PokeDetailViewModel
import com.example.pokedex.viewmodel.PokeDetailViewModelFactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val TAG: String = SecondFragment::class.java.simpleName


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentSecondBinding.inflate(inflater)

        binding.lifecycleOwner = this

        val pokemonId = SecondFragmentArgs.fromBundle(requireArguments()).pokemon
        Log.d(TAG, "Pokemon ID " + pokemonId)
        
        val viewModelFactory = PokeDetailViewModelFactory(pokemonId, application)

        binding.viewmodel = ViewModelProvider(
            this, viewModelFactory
        ).get(PokeDetailViewModel::class.java)

        return binding.root

    }
}