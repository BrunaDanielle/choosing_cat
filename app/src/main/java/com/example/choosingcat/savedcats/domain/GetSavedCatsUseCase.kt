package com.example.choosingcat.savedcats.domain

import com.example.choosingcat.savedcats.domain.model.SavedCat
import kotlinx.coroutines.flow.Flow

class GetSavedCatsUseCase(private val repository: SavedCatsRepository) {
    operator fun invoke(): Flow<List<SavedCat>> = repository.getSavedCats()
}