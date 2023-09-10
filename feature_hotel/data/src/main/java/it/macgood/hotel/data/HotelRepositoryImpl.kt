package it.macgood.hotel.data

import android.content.Context
import it.macgood.core.R
import it.macgood.core.Resource
import it.macgood.core.handleException
import it.macgood.hotel.domain.Hotel
import it.macgood.hotel.domain.HotelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    private val api: HotelApi,
    private val context: Context
) : HotelRepository {

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
}