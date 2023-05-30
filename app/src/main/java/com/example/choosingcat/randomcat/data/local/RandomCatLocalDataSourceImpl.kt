package com.example.choosingcat.randomcat.data.local

import com.example.choosingcat.randomcat.data.local.database.dao.RandomCatDAO
import com.example.choosingcat.randomcat.data.local.database.mapper.toCatEntity
import com.example.choosingcat.randomcat.data.repository.RandomCatLocalDataSource
import com.example.choosingcat.randomcat.domain.model.Cat

class RandomCatLocalDataSourceImpl(private val dao: RandomCatDAO): RandomCatLocalDataSource {

    override suspend fun insertRandomCat(randomCat: Cat) {
        dao.insert(randomCat.toCatEntity())
    }
}