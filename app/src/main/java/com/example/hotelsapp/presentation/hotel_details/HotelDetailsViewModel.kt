package com.example.hotelsapp.presentation.hotel_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelsapp.domain.usecase.GetHotelByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getHotelByIdUseCase: GetHotelByIdUseCase
) : ViewModel() {

    private val hotelId: String = savedStateHandle.get<String>("hotelId").orEmpty()

    private val _state = MutableStateFlow(HotelDetailsUiState(isLoading = true))
    val state: StateFlow<HotelDetailsUiState> = _state.asStateFlow()

    init {
        loadHotel()
    }

    private fun loadHotel() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)

            runCatching { getHotelByIdUseCase(hotelId) }
                .onSuccess { hotel ->
                    _state.value = if (hotel != null) {
                        HotelDetailsUiState(
                            isLoading = false,
                            hotel = hotel
                        )
                    } else {
                        HotelDetailsUiState(
                            isLoading = false,
                            error = "Hotel not found"
                        )
                    }
                }
                .onFailure { throwable ->
                    _state.value = HotelDetailsUiState(
                        isLoading = false,
                        error = throwable.message ?: "Something went wrong"
                    )
                }
        }
    }
}