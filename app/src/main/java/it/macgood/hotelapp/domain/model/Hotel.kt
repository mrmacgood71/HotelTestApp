package it.macgood.hotelapp.domain.model

data class Hotel(
    val id: Int,
    val name: String,
    val address: String,
    val aboutTheHotel: AboutTheHotel,
    val imageUrls: List<String>,
    val minimalPrice: Int,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String
)