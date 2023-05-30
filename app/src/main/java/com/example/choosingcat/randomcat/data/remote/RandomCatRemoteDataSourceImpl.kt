package com.example.choosingcat.randomcat.data.remote

import com.example.choosingcat.randomcat.data.remote.api.RandomCatApi
import com.example.choosingcat.randomcat.data.remote.mappers.toCat
import com.example.choosingcat.randomcat.data.repository.RandomCatRemoteDataSource
import com.example.choosingcat.randomcat.domain.exceptions.GetRandomCatException
import com.example.choosingcat.randomcat.domain.model.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RandomCatRemoteDataSourceImpl(private val service: RandomCatApi) : RandomCatRemoteDataSource {
    override fun getRandomCat(): Flow<Cat> =
        flow {
            try {
                val catRemote = service.getCat().first()
                emit(catRemote.toCat())
            } catch (e: NoSuchElementException) {
                throw GetRandomCatException("Api não retornou nenhum gato")
            }
        }
}