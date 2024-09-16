package com.example.choosingcat.randomcat.data.remote

import com.example.choosingcat.randomcat.data.remote.api.RandomCatApi
import com.example.choosingcat.randomcat.data.remote.mappers.RandomCatMapper
import com.example.choosingcat.randomcat.data.repository.RandomCatRemoteDataSource
import com.example.choosingcat.randomcat.domain.exceptions.GetRandomCatException
import com.example.choosingcat.randomcat.domain.model.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class RandomCatRemoteDataSourceImpl(
    private val service: RandomCatApi,
    private val mapper: RandomCatMapper
) : RandomCatRemoteDataSource {
    override fun getRandomCat(): Flow<Cat> =
        flow {
            val catRemote = service.getCat().first()
            emit(mapper.map(catRemote))
        }.catch {
            throw GetRandomCatException("Api não retornou nenhum gato")
        }
}