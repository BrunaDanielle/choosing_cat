package com.example.choosingcat.savedcats.data.local.mapper

import com.example.choosingcat.common.data.local.database.model.CatEntity
import com.example.choosingcat.savedcats.domain.model.SavedCat

interface SavedCatMapper {
    fun map(cat: List<CatEntity>): List<SavedCat>
}