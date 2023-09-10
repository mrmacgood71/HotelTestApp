package it.macgood.hotelapp.domain.repository

import it.macgood.core.Resource
import it.macgood.hotelapp.domain.model.Hotel
import it.macgood.hotelapp.domain.model.Room
import it.macgood.hotelapp.domain.model.RoomReservation
import kotlinx.coroutines.flow.Flow

interface HotelsRepository {
    suspend fun getHotel(): Flow<Resource<Hotel>>
    suspend fun getRooms(): Flow<Resource<List<Room>>>
    suspend fun getRoomReservationInfo(): Flow<Resource<RoomReservation>>
}