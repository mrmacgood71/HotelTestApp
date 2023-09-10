package it.macgood.hotelapp.room

import it.macgood.hotelapp.domain.model.Room

data class RoomsState(
    val hotelName: String? = null,
    val rooms: List<Room> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)