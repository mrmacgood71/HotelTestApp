package it.macgood.room.domain.repository

import it.macgood.core.Resource
import it.macgood.room.domain.model.Room
import kotlinx.coroutines.flow.Flow

interface RoomsRepository {
    suspend fun getRooms(): Flow<Resource<List<Room>>>
}