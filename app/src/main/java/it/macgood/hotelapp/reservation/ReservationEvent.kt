package it.macgood.hotelapp.reservation

sealed class ReservationEvent {
    data class OnNumberChanged(val number: String) : ReservationEvent()
    object None : ReservationEvent()
}
