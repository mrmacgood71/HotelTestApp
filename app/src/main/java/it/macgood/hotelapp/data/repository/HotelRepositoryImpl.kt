package it.macgood.hotelapp.data.repository

import android.content.Context
import android.util.Log
import it.macgood.core.R
import it.macgood.core.Resource
import it.macgood.core.handleException
import it.macgood.hotelapp.data.api.HotelsApi
import it.macgood.hotelapp.data.model.toHotel
import it.macgood.hotelapp.data.model.toRoomReservation
import it.macgood.hotelapp.data.model.toRoomResponse
import it.macgood.hotelapp.domain.model.Hotel
import it.macgood.hotelapp.domain.model.Room
import it.macgood.hotelapp.domain.model.RoomReservation
import it.macgood.hotelapp.domain.repository.HotelsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    private val api: HotelsApi,
    private val context: Context
) : HotelsRepository {

    override suspend fun getHotel(): Flow<Resource<Hotel>> = flow {
        try {
            val response = api.getHotel()
            if (response.body() != null) {
                emit(Resource.Success<Hotel>(response.body()!!.toHotel()))
            } else {
                emit(Resource.Error<Hotel>(context.getString(R.string.response_is_null)))
            }
        } catch (e: Exception) {
            emit(handleException<Hotel>(e, context))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getRooms(): Flow<Resource<List<Room>>> = flow {
        try {
            val response = api.getRooms()

            if (response.body() != null) {
                emit(Resource.Success(response.body()!!.toRoomResponse().rooms))
            } else {
                emit(Resource.Error(context.getString(R.string.response_is_null)))
            }
        } catch (e: Exception) {
            Log.d("TAG", "getRooms: $e")
            emit(handleException(e, context))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getRoomReservationInfo(): Flow<Resource<RoomReservation>> = flow {
        try {
            val response = api.getRoomReservationInfo()
            if (response.body() != null) {
                emit(Resource.Success(response.body()!!.toRoomReservation()))
            } else {
                emit(Resource.Error(context.getString(R.string.response_is_null)))
            }
        } catch (e: Exception) {
            emit(handleException(e, context))
        }
    }.flowOn(Dispatchers.IO)
}