package com.example.choosingcat.randomcat.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.choosingcat.R
import com.example.choosingcat.databinding.ActivityMainBinding
import com.example.choosingcat.savedcats.presentation.SavedCatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RandomCatActivity : AppCompatActivity(R.layout.activity_main) {
    private val randomCatViewModel: RandomCatViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObserver()
        setListener()
    }

    private fun setObserver() {
        randomCatViewModel.stateLiveData.observe(this) { result ->
            when (result) {
                RandomCatState.Error -> {
                    binding.tvText.text = getString(R.string.error_message)
                }
                RandomCatState.Loading -> {
                    binding.tvText.text = getString(R.string.loading_label)
                }
                is RandomCatState.ShowingRandomCat -> {
                    with(result.cat) {
                        binding.tvText.text = id
                        binding.tvUrl.text = catPhotoUrl
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        randomCatViewModel.searchCat()
    }

    private fun setListener() {
        binding.btnSavedCats.setOnClickListener {
            val myIntent = Intent(this, SavedCatActivity::class.java)
            startActivity(myIntent)
        }
    }
}