package it.macgood.presentation.room

import it.macgood.room.domain.model.Room

data class RoomsState(
    val hotelName: String? = null,
    val rooms: List<Room> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)