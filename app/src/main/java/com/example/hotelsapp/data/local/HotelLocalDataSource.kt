package com.example.hotelsapp.data.local

import android.content.Context
import com.example.hotelsapp.data.local.dto.HotelResponseDto
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class HotelLocalDataSource @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson
) {
    fun getHotels(): HotelResponseDto {
        val json = context.assets
            .open("Hotels.json")
            .bufferedReader()
            .use { it.readText() }
        return gson.fromJson(json, HotelResponseDto::class.java)
    }
}