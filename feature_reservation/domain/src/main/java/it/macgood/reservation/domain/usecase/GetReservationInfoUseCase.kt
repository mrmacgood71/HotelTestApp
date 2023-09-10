package it.macgood.reservation.domain.usecase

import it.macgood.reservation.domain.repository.ReservationRepository
import javax.inject.Inject

class GetReservationInfoUseCase @Inject constructor(
    private val repository: ReservationRepository
) {
    suspend operator fun invoke() = repository.getRoomReservationInfo()
}