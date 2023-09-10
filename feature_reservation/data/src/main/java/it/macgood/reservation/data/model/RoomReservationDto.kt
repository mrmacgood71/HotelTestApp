package it.macgood.reservation.data.model

import com.google.gson.annotations.SerializedName
import it.macgood.reservation.domain.model.RoomReservation

data class RoomReservationDto(
    val id: Int,
    @SerializedName("arrival_country")
    val arrivalCountry: String,
    val departure: String,
    @SerializedName("fuel_charge")
    val fuelCharge: Int,
    @SerializedName("horating")
    val hotelRating: Int,
    @SerializedName("hotel_adress")
    val hotelAddress: String,
    @SerializedName("hotel_name")
    val hotelName: String,
    @SerializedName("number_of_nights")
    val numberOfNights: Int,
    val nutrition: String,
    @SerializedName("rating_name")
    val ratingName: String,
    val room: String,
    @SerializedName("service_charge")
    val serviceCharge: Int,
    @SerializedName("tour_date_start")
    val tourDateStart: String,
    @SerializedName("tour_date_stop")
    val tourDateStop: String,
    @SerializedName("tour_price")
    val tourPrice: Int
)

fun RoomReservationDto.toRoomReservation() = RoomReservation(id, arrivalCountry, departure, fuelCharge, hotelRating, hotelAddress, hotelName, numberOfNights, nutrition, ratingName, room, serviceCharge, tourDateStart, tourDateStop, tourPrice)