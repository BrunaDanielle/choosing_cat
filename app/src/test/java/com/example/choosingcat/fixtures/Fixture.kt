package com.example.choosingcat.fixtures

import com.example.choosingcat.common.data.local.database.model.CatEntity
import com.example.choosingcat.randomcat.data.remote.model.RandomCatResponse
import com.example.choosingcat.randomcat.domain.model.Cat

object Fixture {
    val catDomain = Cat(
        id = "123",
        catPhotoUrl = "http://example.com/cat.jpg"
    )
    val expectedCatEntity = CatEntity(
        id = "123",
        catPhotoUrl = "http://example.com/cat.jpg"
    )

    val randomCatResponse = RandomCatResponse(
        id = "123",
        catPhotoUrl = "http://example.com/cat.jpg"
    )
}