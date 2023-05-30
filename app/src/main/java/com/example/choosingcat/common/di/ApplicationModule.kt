package com.example.choosingcat.common.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import org.koin.dsl.module
import retrofit2.Retrofit

object ApplicationModule {
    private const val BASE_URL = "https://api.thecatapi.com/v1/"

    val networkModule = module {
        single {
            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(get())
                .build()
        }
        factory { Json.asConverterFactory(MediaType.get("application/json")) }
    }
}