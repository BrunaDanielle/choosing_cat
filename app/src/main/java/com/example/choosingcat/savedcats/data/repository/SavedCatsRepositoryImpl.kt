package com.example.choosingcat.savedcats.data.repository

import com.example.choosingcat.savedcats.domain.model.SavedCat
import com.example.choosingcat.savedcats.domain.SavedCatsRepository
import kotlinx.coroutines.flow.Flow

class SavedCatsRepositoryImpl(
    private val localDataSource: SavedCatsLocalDataSource
) : SavedCatsRepository {
    override fun getSavedCats(): Flow<List<SavedCat>> =
        localDataSource.fetchSavedCats()
}