package com.example.choosingcat.randomcat.data.remote.mappers

import com.example.choosingcat.randomcat.data.remote.model.RandomCatResponse
import com.example.choosingcat.randomcat.domain.model.Cat

class RandomCatMapperImpl : RandomCatMapper {
    override fun map(catResponse: RandomCatResponse) = Cat(
        id = catResponse.id.orEmpty(),
        catPhotoUrl = catResponse.catPhotoUrl.orEmpty()
    )
}