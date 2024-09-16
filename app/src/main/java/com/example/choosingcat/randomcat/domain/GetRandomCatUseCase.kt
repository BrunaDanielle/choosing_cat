package com.example.choosingcat.randomcat.domain

import com.example.choosingcat.randomcat.domain.model.Cat
import kotlinx.coroutines.flow.Flow

class GetRandomCatUseCase(private val repository: RandomCatRepository) {
    operator fun invoke(): Flow<Cat> = repository.getRandomCat()
}
