package com.example.choosingcat.common.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.choosingcat.common.data.local.database.dao.CatDAO
import com.example.choosingcat.common.data.local.database.model.CatEntity

@Database(entities = [CatEntity::class], version = 1)
abstract class CatRoomDatabase : RoomDatabase() {

    abstract fun randomCatDAO(): CatDAO
}