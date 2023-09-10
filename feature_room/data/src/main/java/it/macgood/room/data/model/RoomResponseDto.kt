package it.macgood.room.data.model

import it.macgood.room.domain.model.RoomResponse

data class RoomResponseDto(
    val rooms: List<RoomDto>
)

fun RoomResponseDto.toRoomResponse(): RoomResponse = RoomResponse(this.rooms.map { it.toRoom() })