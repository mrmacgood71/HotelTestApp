package it.macgood.room.data.model

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class RoomListDeserializer : JsonDeserializer<List<RoomDto>> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<RoomDto> {
        val roomList = mutableListOf<RoomDto>()
        val rootJsonObject = json.asJsonObject
        val roomsJsonArray = rootJsonObject.getAsJsonArray("rooms")
        roomsJsonArray?.forEach { roomJson ->
            val room = context?.deserialize<RoomDto>(roomJson, RoomDto::class.java)
            room?.let { roomList.add(it) }
        }
        return roomList
    }
}