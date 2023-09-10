package it.macgood.room.data.api

import it.macgood.room.data.model.RoomResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface RoomsApi {
    @GET("f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getRooms(): Response<RoomResponseDto>

    companion object {
        const val BASE_URL = "https://run.mocky.io/v3/"
    }
}