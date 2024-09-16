package com.example.choosingcat.savedcats.data.repository

import com.example.choosingcat.savedcats.domain.model.SavedCat
import kotlinx.coroutines.flow.Flow

interface SavedCatsLocalDataSource {
    fun fetchSavedCats(): Flow<List<SavedCat>>
}