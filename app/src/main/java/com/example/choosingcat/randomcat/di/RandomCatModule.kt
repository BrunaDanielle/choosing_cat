package com.example.choosingcat.randomcat.di

import androidx.room.Room
import com.example.choosingcat.randomcat.data.local.RandomCatLocalDataSourceImpl
import com.example.choosingcat.randomcat.data.local.database.RandomCatRoomDatabase
import com.example.choosingcat.randomcat.data.remote.RandomCatRemoteDataSourceImpl
import com.example.choosingcat.randomcat.data.remote.api.RandomCatApi
import com.example.choosingcat.randomcat.data.repository.RandomCatRepositoryImpl
import com.example.choosingcat.randomcat.domain.GeRandomCatUseCase
import com.example.choosingcat.randomcat.presentation.RandomCatViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val randomCatNetworkModule = module {
    factory { get<Retrofit>().create(RandomCatApi::class.java) }
}

val randomCatDataModule = module {
    single {
        Room.databaseBuilder(
            androidContext(), RandomCatRoomDatabase::class.java,
            "Random_cat.db"
        ).build()
    }

    single { get<RandomCatRoomDatabase>().randomCatDAO() }
}

val randomCatPresentationModule = module {
    factory {
        GeRandomCatUseCase(
            RandomCatRepositoryImpl(
                RandomCatRemoteDataSourceImpl(get()),
                RandomCatLocalDataSourceImpl(get())
            )
        )
    }

    viewModel { RandomCatViewModel(useCase = get()) }
}