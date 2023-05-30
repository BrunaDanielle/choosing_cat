package com.example.choosingcat.randomcat.data.local.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "random_cat_table")
data class RandomCatEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "cat_photo_url" ) val catPhotoUrl: String,
)