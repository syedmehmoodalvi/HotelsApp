package com.example.hotelsapp.domain.model

import kotlinx.serialization.SerialName

data class Hotel(
    val city: String,
    val country: String,
    val description: String,
    val id: String,
    val images: List<String>,
    val name: String,
    val starRating: Int
)