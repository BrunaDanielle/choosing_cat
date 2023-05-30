package com.example.choosingcat.randomcat.data.repository

import com.example.choosingcat.randomcat.domain.model.Cat

interface RandomCatLocalDataSource {
    suspend fun insertRandomCat(randomCat: Cat)
}