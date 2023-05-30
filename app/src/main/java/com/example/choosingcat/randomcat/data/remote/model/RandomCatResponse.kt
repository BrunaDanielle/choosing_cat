package com.example.choosingcat.randomcat.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomCatResponse(
    @SerialName("breeds")
    val catBreeds: List<String>? = null,
    val id: String,
    @SerialName("url")
    val catPhotoUrl: String,
    @SerialName("width")
    val imgWidth: Int,
    @SerialName("height")
    val imgHeight: Int,
)