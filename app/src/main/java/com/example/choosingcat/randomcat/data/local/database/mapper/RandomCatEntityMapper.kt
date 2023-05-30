package com.example.choosingcat.randomcat.data.local.database.mapper

import com.example.choosingcat.randomcat.data.local.database.model.RandomCatEntity
import com.example.choosingcat.randomcat.domain.model.Cat

fun Cat.toCatEntity() = RandomCatEntity(
    id = id,
    catPhotoUrl = catPhotoUrl
)