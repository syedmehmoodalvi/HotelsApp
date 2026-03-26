package com.example.hotelsapp.data.mapper

import com.example.hotelsapp.data.local.dto.HotelDto
import com.example.hotelsapp.domain.model.Hotel

fun HotelDto.toDomain(): Hotel {
    return Hotel(
        city = city,
        country = country,
        description = description,
        id = id,
        name = name,
        images = images,
        starRating = starRating
    )
}