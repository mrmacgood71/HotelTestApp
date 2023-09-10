package it.macgood.room.data.model

import com.google.gson.annotations.SerializedName
import it.macgood.room.domain.model.Room

data class RoomDto(
    val id: Int,
    @SerializedName("image_urls")
    val imageUrls: List<String>,
    val name: String,
    val peculiarities: List<String>,
    val price: Int,
    @SerializedName("price_per")
    val pricePer: String
)

fun RoomDto.toRoom() = Room(id, imageUrls, name, peculiarities, price, pricePer)