package com.example.hotelsapp.domain.repository

import com.example.hotelsapp.domain.model.Hotel

interface HotelRepository {
    fun getHotels(): List<Hotel>
    fun getHotelById(id: String): Hotel?
}