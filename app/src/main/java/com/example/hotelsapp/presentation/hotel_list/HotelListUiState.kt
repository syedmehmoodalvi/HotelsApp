package com.example.hotelsapp.presentation.hotel_list

import com.example.hotelsapp.domain.model.Hotel

data class HotelListUiState(
    val isLoading: Boolean = false,
    val hotels: List<Hotel> = emptyList(),
    val filteredHotels: List<Hotel> = emptyList(),
    val searchQuery: String = "",
    val error: String? = null
)