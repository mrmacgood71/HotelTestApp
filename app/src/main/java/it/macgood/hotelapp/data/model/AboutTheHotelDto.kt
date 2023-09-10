package it.macgood.hotelapp.data.model

import it.macgood.hotelapp.domain.model.AboutTheHotel

data class AboutTheHotelDto(
    val description: String,
    val peculiarities: List<String>
)

fun AboutTheHotelDto.toAboutTheHotel() : AboutTheHotel {
    return AboutTheHotel(description, peculiarities)
}