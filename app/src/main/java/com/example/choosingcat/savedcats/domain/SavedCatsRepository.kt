package com.example.choosingcat.savedcats.domain

import com.example.choosingcat.savedcats.domain.model.SavedCat
import kotlinx.coroutines.flow.Flow

interface SavedCatsRepository {
    fun getSavedCats(): Flow<List<SavedCat>>
}