package it.macgood.reservation.data.repository

import android.content.Context
import it.macgood.core.R
import it.macgood.core.Resource
import it.macgood.core.handleException
import it.macgood.reservation.data.api.ReservationApi
import it.macgood.reservation.data.model.toRoomReservation
import it.macgood.reservation.domain.model.RoomReservation
import it.macgood.reservation.domain.repository.ReservationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ReservationRepositoryImpl @Inject constructor(
    private val api: ReservationApi,
    private val context: Context
) : ReservationRepository {
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