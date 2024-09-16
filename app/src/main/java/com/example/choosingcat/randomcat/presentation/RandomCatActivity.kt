package com.example.choosingcat.randomcat.presentation

import android.content.Intent
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import coil.load
import com.example.choosingcat.R
import com.example.choosingcat.databinding.ActivityMainBinding
import com.example.choosingcat.savedcats.presentation.SavedCatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RandomCatActivity : AppCompatActivity(R.layout.activity_main) {
    @VisibleForTesting
    val randomCatViewModel: RandomCatViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObserver()
        setListener()
        setActionObserver()
    }

    private fun setObserver() {
        randomCatViewModel.stateLiveData.observe(this) { result ->
            when (result) {
                RandomCatState.Error -> showError()
                RandomCatState.Loading -> showLoading()
                is RandomCatState.ShowingRandomCat -> showRandomCat(result)
            }
        }
    }

    private fun setActionObserver() {
        randomCatViewModel.actionLiveData.observe(this) { action ->
            when (action) {
                RandomCatAction.OpenSavedCatsView -> navigateToSavedCatsView()
            }
        }
    }

    private fun showRandomCat(result: RandomCatState.ShowingRandomCat) {
        with(binding) {
            catImageView.load(result.cat.catPhotoUrl) {
                listener(
                    onSuccess = { _, _ ->
                        setLoadingVisibility(false)
                        setSuccessVisibility(true)
                        setErrorVisibility(false)
                        titleTextView.text = result.cat.id
                    },
                    onError = { _, _ ->
                        showError()
                    }
                )
            }
        }
    }

    private fun showLoading() {
        setLoadingVisibility(true)
        setSuccessVisibility(false)
        setErrorVisibility(false)
    }

    private fun showError() {
        setLoadingVisibility(false)
        setSuccessVisibility(false)
        setErrorVisibility(true)
    }

    private fun setSuccessVisibility(isVisible: Boolean) {
        with(binding) {
            catImageView.isVisible = isVisible
            titleTextView.isVisible = isVisible
            idTextView.isVisible = isVisible
        }
    }

    private fun setLoadingVisibility(isVisible: Boolean) {
        binding.loadingProgressBar.isVisible = isVisible
    }

    private fun setErrorVisibility(isVisible: Boolean) {
        binding.errorTextView.isVisible = isVisible
    }

    private fun setListener() {
        binding.savedCatsButton.setOnClickListener {
            randomCatViewModel.onOpenSavedCatsView()
        }

        binding.reloadCatButton.setOnClickListener {
            randomCatViewModel.onReloadData()
        }
    }

    private fun navigateToSavedCatsView() {
        val myIntent = Intent(this, SavedCatActivity::class.java)
        startActivity(myIntent)
    }
}