package it.macgood.hotel.domain

import it.macgood.core.Resource
import kotlinx.coroutines.flow.Flow

interface HotelRepository {
    suspend fun getHotel(): Flow<Resource<Hotel>>
}