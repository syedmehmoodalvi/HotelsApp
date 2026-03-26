package com.example.hotelsapp.data.local.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HotelDto(
    @SerialName("city")
    val city: String,
    @SerialName("country")
    val country: String,
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: String,
    @SerialName("images")
    val images: List<String>,
    @SerialName("name")
    val name: String,
    @SerialName("star_rating")
    val starRating: Int
)