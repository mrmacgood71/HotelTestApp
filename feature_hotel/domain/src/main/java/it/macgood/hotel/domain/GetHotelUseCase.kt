package it.macgood.hotel.domain

import javax.inject.Inject

class GetHotelUseCase @Inject constructor(
    private val repository: HotelRepository
) {
    suspend operator fun invoke() = repository.getHotel()
}