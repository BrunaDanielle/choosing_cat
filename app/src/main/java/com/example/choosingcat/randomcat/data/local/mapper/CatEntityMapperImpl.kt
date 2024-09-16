package com.example.choosingcat.randomcat.data.local.mapper

import com.example.choosingcat.common.data.local.database.model.CatEntity
import com.example.choosingcat.randomcat.domain.model.Cat

class CatEntityMapperImpl : CatEntityMapper {
    override fun map(catDomain: Cat) = CatEntity(
        id = catDomain.id,
        catPhotoUrl = catDomain.catPhotoUrl
    )
}