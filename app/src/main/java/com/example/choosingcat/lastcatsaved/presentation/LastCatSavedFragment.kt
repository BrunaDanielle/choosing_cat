package com.example.choosingcat.lastcatsaved.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.choosingcat.R
import com.example.choosingcat.databinding.FragmentLastCatSavedBinding

class LastCatSavedFragment : Fragment(R.layout.fragment_last_cat_saved) {

    private var _binding: FragmentLastCatSavedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLastCatSavedBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackToCats.setOnClickListener {
            findNavController().navigate(R.id.action_lastCatSavedFragment_to_savedCatFragment2)
        }
    }
}