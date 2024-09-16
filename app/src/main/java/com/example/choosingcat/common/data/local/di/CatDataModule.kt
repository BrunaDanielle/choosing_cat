package com.example.choosingcat.common.data.local.di

import androidx.room.Room
import com.example.choosingcat.common.data.local.database.CatRoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object CatDataModule {
    val catDataModule = module {
        single {
            Room.databaseBuilder(
                androidContext(), CatRoomDatabase::class.java,
                "Random_cat.db"
            ).build()
        }

        single { get<CatRoomDatabase>().randomCatDAO() }
    }
}