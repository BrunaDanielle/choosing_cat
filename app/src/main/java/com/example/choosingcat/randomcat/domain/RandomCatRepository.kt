package com.example.choosingcat.randomcat.domain

import com.example.choosingcat.randomcat.domain.model.Cat
import kotlinx.coroutines.flow.Flow

interface RandomCatRepository {
    fun getRandomCat(): Flow<Cat>
}