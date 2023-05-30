package com.example.choosingcat.randomcat.data.remote.mappers

import com.example.choosingcat.randomcat.data.remote.model.RandomCatResponse
import com.example.choosingcat.randomcat.domain.model.Cat

fun RandomCatResponse.toCat() = Cat(
    id = id,
    catPhotoUrl = catPhotoUrl
)