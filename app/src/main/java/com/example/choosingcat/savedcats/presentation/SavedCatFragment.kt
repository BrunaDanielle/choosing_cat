package com.example.choosingcat.savedcats.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.choosingcat.R
import com.example.choosingcat.databinding.FragmentSavedCatBinding
import com.example.choosingcat.savedcats.domain.model.SavedCat
import com.example.choosingcat.savedcats.presentation.adapter.SavedCatsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SavedCatFragment : Fragment(R.layout.fragment_saved_cat) {
    private val savedCatViewModel: SavedCatViewModel by viewModel()
    private lateinit var savedCatsAdapter: SavedCatsAdapter
    private lateinit var binding: FragmentSavedCatBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSavedCatBinding.bind(view)

        setupRecyclerView()
        setObserver()
    }

    private fun setupRecyclerView() {
        savedCatsAdapter = SavedCatsAdapter(emptyList())
        binding.savedCatsRecyclerView.apply {
            adapter = savedCatsAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setObserver() {
        savedCatViewModel.stateLiveData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is SavedCatsState.Loading -> showLoading()
                is SavedCatsState.Error -> showError()
                is SavedCatsState.ShowingSavedCats -> showSavedCats(result.cats)
            }
        }
    }

    private fun showLoading() {
        setLoadingVisibility(true)
        setErrorVisibility(false)
        setSuccessVisibility(false)
    }

    private fun showError() {
        setLoadingVisibility(false)
        setErrorVisibility(true)
        setSuccessVisibility(false)
    }

    private fun showSavedCats(cats: List<SavedCat>) {
        with(binding) {
            setLoadingVisibility(false)
            setErrorVisibility(false)
            setSuccessVisibility(true)
            savedCatsAdapter = SavedCatsAdapter(cats)
            savedCatsRecyclerView.adapter = savedCatsAdapter
        }
    }

    private fun setSuccessVisibility(isVisible: Boolean) {
        binding.savedCatsRecyclerView.isVisible = isVisible
    }

    private fun setLoadingVisibility(isVisible: Boolean) {
        binding.loadingProgressBar.isVisible = isVisible
    }

    private fun setErrorVisibility(isVisible: Boolean) {
        binding.errorTextView.isVisible = isVisible
    }
}