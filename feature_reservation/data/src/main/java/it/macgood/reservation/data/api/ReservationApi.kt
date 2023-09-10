package it.macgood.reservation.data.api

import it.macgood.reservation.data.model.RoomReservationDto
import retrofit2.Response
import retrofit2.http.GET

interface ReservationApi {
    @GET("e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getRoomReservationInfo(): Response<RoomReservationDto>
}