package it.macgood.hotel.data

import com.google.gson.annotations.SerializedName
import it.macgood.hotel.domain.Hotel
import it.macgood.hotelapp.domain.model.AboutTheHotel


data class HotelDto(
    val id: Int,
    val name: String,
    @SerializedName("adress")
    val address: String,
    @SerializedName("about_the_hotel")
    val aboutTheHotel: AboutTheHotel,
    @SerializedName("image_urls")
    val imageUrls: List<String>,
    @SerializedName("minimal_price")
    val minimalPrice: Int,
    @SerializedName("price_for_it")
    val priceForIt: String,
    val rating: Int,
    @SerializedName("rating_name")
    val ratingName: String
)

fun HotelDto.toHotel(): Hotel {
    return Hotel(id, name, address, aboutTheHotel, imageUrls, minimalPrice, priceForIt, rating, ratingName)
}