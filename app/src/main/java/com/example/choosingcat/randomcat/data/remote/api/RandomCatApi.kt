package com.example.choosingcat.randomcat.data.remote.api

import com.example.choosingcat.randomcat.data.remote.model.RandomCatResponse
import retrofit2.http.GET

interface RandomCatApi {
    @GET("images/search")
    suspend fun getCat(): List<RandomCatResponse>
}