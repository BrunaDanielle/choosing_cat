package com.example.choosingcat.randomcat.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.choosingcat.randomcat.data.local.database.model.RandomCatEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RandomCatDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(randomCatEntity: RandomCatEntity)

    @Query("SELECT * FROM random_cat_table")
    fun getAllRandomCats() : List<RandomCatEntity>
}