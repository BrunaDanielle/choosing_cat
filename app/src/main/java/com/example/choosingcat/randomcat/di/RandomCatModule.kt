package com.example.choosingcat.randomcat.di

import com.example.choosingcat.randomcat.data.local.RandomCatLocalDataSourceImpl
import com.example.choosingcat.randomcat.data.local.mapper.CatEntityMapper
import com.example.choosingcat.randomcat.data.local.mapper.CatEntityMapperImpl
import com.example.choosingcat.randomcat.data.remote.RandomCatRemoteDataSourceImpl
import com.example.choosingcat.randomcat.data.remote.api.RandomCatApi
import com.example.choosingcat.randomcat.data.remote.mappers.RandomCatMapper
import com.example.choosingcat.randomcat.data.remote.mappers.RandomCatMapperImpl
import com.example.choosingcat.randomcat.data.repository.RandomCatRepositoryImpl
import com.example.choosingcat.randomcat.domain.GetRandomCatUseCase
import com.example.choosingcat.randomcat.presentation.RandomCatViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val randomCatNetworkModule = module {
    factory { get<Retrofit>().create(RandomCatApi::class.java) }
}

val randomCatDataModule = module {
    factory<CatEntityMapper> { CatEntityMapperImpl() }
    factory<RandomCatMapper> { RandomCatMapperImpl() }
}

val randomCatPresentationModule = module {
    factory {
        GetRandomCatUseCase(
            RandomCatRepositoryImpl(
                RandomCatRemoteDataSourceImpl(get(), get()),
                RandomCatLocalDataSourceImpl(get(), get())
            )
        )
    }
    viewModel { RandomCatViewModel(useCase = get()) }
}