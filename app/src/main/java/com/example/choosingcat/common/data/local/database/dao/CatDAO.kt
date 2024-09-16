package com.example.choosingcat.common.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.choosingcat.common.data.local.database.model.CatEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CatDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(catEntity: CatEntity)

    @Query("SELECT * FROM random_cat_table")
    fun getAllRandomCats() : Flow<List<CatEntity>>
}