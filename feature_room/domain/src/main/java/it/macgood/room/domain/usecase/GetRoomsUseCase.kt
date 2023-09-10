package it.macgood.room.domain.usecase

import it.macgood.room.domain.repository.RoomsRepository
import javax.inject.Inject

class GetRoomsUseCase @Inject constructor(
    private val repository: RoomsRepository
) {
    suspend operator fun invoke() = repository.getRooms()
}