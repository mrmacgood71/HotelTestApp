package it.macgood.hotelapp.reservation

import it.macgood.hotelapp.domain.model.RoomReservation

data class ReservationState(
    val reservation: RoomReservation? = null,
    val number: String = "",
    val error: String? = null,
    val isLoading: Boolean = true
)