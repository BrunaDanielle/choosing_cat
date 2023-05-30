package com.example.choosingcat.randomcat.data.repository

import com.example.choosingcat.randomcat.domain.RandomCatRepository
import com.example.choosingcat.randomcat.domain.model.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class RandomCatRepositoryImpl(
    private val remoteDataSource: RandomCatRemoteDataSource,
    private val localDataSource: RandomCatLocalDataSource
) : RandomCatRepository {

    override fun getRandomCat(): Flow<Cat> =
        remoteDataSource
            .getRandomCat()
            .onEach { cat ->
                saveRandomCat(cat)
            }

    private suspend fun saveRandomCat(randomCat: Cat) {
        localDataSource.insertRandomCat(randomCat)
    }
}