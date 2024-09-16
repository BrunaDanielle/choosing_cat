package com.example.choosingcat.randomcat.data.local

import com.example.choosingcat.common.data.local.database.dao.CatDAO
import com.example.choosingcat.randomcat.data.local.mapper.CatEntityMapper
import com.example.choosingcat.randomcat.data.repository.RandomCatLocalDataSource
import com.example.choosingcat.randomcat.domain.model.Cat

class RandomCatLocalDataSourceImpl(
    private val dao: CatDAO,
    private val catMapper: CatEntityMapper
) : RandomCatLocalDataSource {

    override suspend fun insertRandomCat(randomCat: Cat) {
        dao.insert(catMapper.map(randomCat))
    }
}