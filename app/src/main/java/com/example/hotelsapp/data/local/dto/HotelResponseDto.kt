package com.example.hotelsapp.data.local.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HotelResponseDto(
    @SerialName("hotels")
    val hotels: List<HotelDto>
)