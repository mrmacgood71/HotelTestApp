package it.macgood.hotelapp.hotel

import it.macgood.hotelapp.domain.model.Hotel

data class HotelState(
    val hotel: Hotel? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)