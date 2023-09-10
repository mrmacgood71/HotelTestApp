package it.macgood.room.data.repository

import android.content.Context
import android.util.Log
import it.macgood.core.R
import it.macgood.core.Resource
import it.macgood.core.handleException
import it.macgood.room.data.api.RoomsApi
import it.macgood.room.data.model.toRoomResponse
import it.macgood.room.domain.model.Room
import it.macgood.room.domain.repository.RoomsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RoomsRepositoryImpl @Inject constructor(
    private val api: RoomsApi,
    private val context: Context
) : RoomsRepository {

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

}