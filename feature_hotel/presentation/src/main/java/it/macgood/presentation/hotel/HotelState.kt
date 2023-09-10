package it.macgood.presentation.hotel

import it.macgood.hotel.domain.Hotel

data class HotelState(
    val hotel: Hotel? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)