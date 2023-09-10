package it.macgood.reservation.domain.repository

import it.macgood.core.Resource
import it.macgood.reservation.domain.model.RoomReservation
import kotlinx.coroutines.flow.Flow

interface ReservationRepository {
    suspend fun getRoomReservationInfo(): Flow<Resource<RoomReservation>>
}