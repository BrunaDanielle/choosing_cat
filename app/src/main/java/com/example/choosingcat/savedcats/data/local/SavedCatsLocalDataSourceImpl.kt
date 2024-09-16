package com.example.choosingcat.savedcats.data.local

import com.example.choosingcat.common.data.local.database.dao.CatDAO
import com.example.choosingcat.savedcats.data.local.mapper.SavedCatMapper
import com.example.choosingcat.savedcats.data.repository.SavedCatsLocalDataSource
import com.example.choosingcat.savedcats.domain.model.SavedCat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SavedCatsLocalDataSourceImpl(
    private val dao: CatDAO,
    private val mapper: SavedCatMapper
) : SavedCatsLocalDataSource {
    override fun fetchSavedCats(): Flow<List<SavedCat>> =
        dao.getAllRandomCats().map { savedCats ->
            mapper.map(savedCats)
        }
}