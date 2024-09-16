package com.example.choosingcat.randomcat.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomCatResponse(
    @SerialName("breeds")
    val catBreeds: List<String>? = null,
    val id: String? = null,
    @SerialName("url")
    val catPhotoUrl: String? = null,
    @SerialName("width")
    val imgWidth: Int? = null,
    @SerialName("height")
    val imgHeight: Int? = null,
)