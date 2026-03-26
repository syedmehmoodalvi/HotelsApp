package com.example.hotelsapp.presentation.hotel_details

import com.example.hotelsapp.domain.model.Hotel

data class HotelDetailsUiState(
    val isLoading: Boolean = false,
    val hotel: Hotel? = null,
    val error: String? = null
)