package com.example.hotelsapp.domain.usecase

import com.example.hotelsapp.domain.model.Hotel
import com.example.hotelsapp.domain.repository.HotelRepository
import javax.inject.Inject

class GetHotelByIdUseCase @Inject constructor(
    private val repository: HotelRepository
) {
    operator fun invoke(id: String): Hotel? = repository.getHotelById(id)
}