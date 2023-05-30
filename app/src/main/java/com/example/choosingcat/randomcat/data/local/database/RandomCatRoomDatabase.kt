package com.example.choosingcat.randomcat.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.choosingcat.randomcat.data.local.database.dao.RandomCatDAO
import com.example.choosingcat.randomcat.data.local.database.model.RandomCatEntity

@Database(entities = [RandomCatEntity::class], version = 1)
abstract class RandomCatRoomDatabase : RoomDatabase() {

    abstract fun randomCatDAO(): RandomCatDAO
}