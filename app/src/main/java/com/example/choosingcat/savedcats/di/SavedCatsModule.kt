package com.example.choosingcat.savedcats.di

import com.example.choosingcat.savedcats.data.local.SavedCatsLocalDataSourceImpl
import com.example.choosingcat.savedcats.data.local.mapper.SavedCatMapper
import com.example.choosingcat.savedcats.data.local.mapper.SavedCatMapperImpl
import com.example.choosingcat.savedcats.data.repository.SavedCatsRepositoryImpl
import com.example.choosingcat.savedcats.domain.GetSavedCatsUseCase
import com.example.choosingcat.savedcats.presentation.SavedCatViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val savedCatsDataModule = module {
    factory<SavedCatMapper> { SavedCatMapperImpl() }
}

val savedCatsPresentationModule = module {
    factory {
        GetSavedCatsUseCase(
            SavedCatsRepositoryImpl(
                SavedCatsLocalDataSourceImpl(get(), get())
            )
        )
    }
    viewModel { SavedCatViewModel(useCase = get()) }
}