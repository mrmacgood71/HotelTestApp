package it.macgood.presentation.reservation

import it.macgood.reservation.domain.model.RoomReservation

data class ReservationState(
    val reservation: RoomReservation? = null,
    val number: String = "",
    val error: String? = null,
    val isLoading: Boolean = true
)