package it.macgood.hotelapp.data.model

import it.macgood.hotelapp.domain.model.RoomResponse

data class RoomResponseDto(
    val rooms: List<RoomDto>
)

fun RoomResponseDto.toRoomResponse(): RoomResponse = RoomResponse(this.rooms.map { it.toRoom() })