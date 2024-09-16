package com.example.choosingcat.savedcats.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.choosingcat.databinding.SavedCatItemBinding
import com.example.choosingcat.savedcats.domain.model.SavedCat

class SavedCatsAdapter(
    private val cats: List<SavedCat>
) : RecyclerView.Adapter<SavedCatsAdapter.SavedCatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedCatViewHolder {
        val binding = SavedCatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SavedCatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedCatViewHolder, position: Int) {
        holder.bind(cats[position])
    }

    override fun getItemCount(): Int = cats.size

    inner class SavedCatViewHolder(
        private val binding: SavedCatItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cat: SavedCat) {
            binding.catNameTextView.text = cat.id
            binding.catImageView.load(cat.catPhotoUrl)
        }
    }
}