package it.macgood.reservation.domain.model

data class RoomReservation(
    val id: Int,
    val arrivalCountry: String,
    val departure: String,
    val fuelCharge: Int,
    val hotelRating: Int,
    val hotelAddress: String,
    val hotelName: String,
    val numberOfNights: Int,
    val nutrition: String,
    val ratingName: String,
    val room: String,
    val serviceCharge: Int,
    val tourDateStart: String,
    val tourDateStop: String,
    val tourPrice: Int
)