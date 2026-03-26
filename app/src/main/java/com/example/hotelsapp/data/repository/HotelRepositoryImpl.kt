package com.example.hotelsapp.data.repository

import com.example.hotelsapp.data.local.HotelLocalDataSource
import com.example.hotelsapp.data.mapper.toDomain
import com.example.hotelsapp.domain.model.Hotel
import com.example.hotelsapp.domain.repository.HotelRepository
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    private val localDataSource: HotelLocalDataSource
) : HotelRepository {
    override fun getHotels(): List<Hotel> {
        return localDataSource.getHotels().hotels.map { it.toDomain() }
    }

    override fun getHotelById(id: String): Hotel? {
        return getHotels().find { it.id == id }
    }
}