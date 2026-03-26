package com.example.hotelsapp.presentation.hotel_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelsapp.domain.usecase.GetHotelsUseCase
import com.example.hotelsapp.presentation.hotel_list.HotelListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelListViewModel @Inject constructor(
    private val getHotelsUseCase: GetHotelsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HotelListUiState(isLoading = true))
    val state: StateFlow<HotelListUiState> = _state.asStateFlow()

    init {
        loadHotels()
    }

    fun onSearchQueryChange(query: String) {
        val allHotels = _state.value.hotels
        _state.value = _state.value.copy(
            searchQuery = query,
            filteredHotels = if (query.isBlank()) {
                allHotels
            } else {
                allHotels.filter {
                    it.name.contains(query, ignoreCase = true) ||
                            it.city.contains(query, ignoreCase = true) ||
                            it.country.contains(query, ignoreCase = true)
                }
            }
        )
    }

    private fun loadHotels() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)

            runCatching { getHotelsUseCase() }
                .onSuccess { hotels ->
                    _state.value = HotelListUiState(
                        isLoading = false,
                        hotels = hotels,
                        filteredHotels = hotels
                    )
                }
                .onFailure { throwable ->
                    _state.value = HotelListUiState(
                        isLoading = false,
                        error = throwable.message ?: "Something went wrong"
                    )
                }
        }
    }
}