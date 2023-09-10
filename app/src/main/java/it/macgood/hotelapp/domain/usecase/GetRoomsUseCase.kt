package it.macgood.hotelapp.domain.usecase

import it.macgood.hotelapp.domain.repository.HotelsRepository
import javax.inject.Inject

class GetRoomsUseCase @Inject constructor(
    private val repository: HotelsRepository
) {
    suspend operator fun invoke() = repository.getRooms()
}