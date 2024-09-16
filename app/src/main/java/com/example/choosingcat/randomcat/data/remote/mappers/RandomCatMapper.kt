package com.example.choosingcat.randomcat.data.remote.mappers

import com.example.choosingcat.randomcat.data.remote.model.RandomCatResponse
import com.example.choosingcat.randomcat.domain.model.Cat

interface RandomCatMapper {
    fun map(catResponse: RandomCatResponse): Cat
}