package it.macgood.hotelapp.data.api

import it.macgood.hotelapp.data.model.HotelDto
import it.macgood.hotelapp.data.model.RoomReservationDto
import it.macgood.hotelapp.data.model.RoomResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface HotelsApi {
    @GET("35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotel(): Response<HotelDto>
    @GET("f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getRooms(): Response<RoomResponseDto>
    @GET("e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getRoomReservationInfo(): Response<RoomReservationDto>

    companion object {
        const val BASE_URL = "https://run.mocky.io/v3/"
    }
}