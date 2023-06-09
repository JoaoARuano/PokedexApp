package com.example.pokedex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.pokedex.adapter.PokeListAdapter
import com.example.pokedex.databinding.FragmentFirstBinding
import com.example.pokedex.viewmodel.PokeListViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val viewModel: PokeListViewModel by viewModels()

    //private var _binding: FragmentFirstBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //_binding = FragmentFirstBinding.inflate(inflater, container, false)

        val binding = FragmentFirstBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewmodel = viewModel

        binding.pokeGrid.adapter = PokeListAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}