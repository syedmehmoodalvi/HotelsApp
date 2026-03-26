package com.example.hotelsapp.di

import com.example.hotelsapp.data.repository.HotelRepositoryImpl
import com.example.hotelsapp.domain.model.Hotel
import com.example.hotelsapp.domain.repository.HotelRepository
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindHotelRepository(impl: HotelRepositoryImpl): HotelRepository

    companion object {
        @Provides
        @Singleton
        fun provideGson(): Gson = Gson()
    }
}