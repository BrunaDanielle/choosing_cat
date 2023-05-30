package com.example.choosingcat.savedcats.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.choosingcat.R
import com.example.choosingcat.databinding.FragmentSavedCatBinding

class SavedCatFragment : Fragment(R.layout.fragment_saved_cat) {

    private var _binding: FragmentSavedCatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSavedCatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGetLastCat.setOnClickListener {
            findNavController().navigate(R.id.action_savedCatFragment2_to_lastCatSavedFragment)
        }
    }
}