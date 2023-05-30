package com.example.choosingcat.randomcat.data.repository

import com.example.choosingcat.randomcat.domain.model.Cat
import kotlinx.coroutines.flow.Flow

interface RandomCatRemoteDataSource {
    fun getRandomCat(): Flow<Cat>
}