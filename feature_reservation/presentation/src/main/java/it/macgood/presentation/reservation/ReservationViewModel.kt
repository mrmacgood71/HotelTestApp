package it.macgood.presentation.reservation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.macgood.core.Resource
import it.macgood.reservation.domain.usecase.GetReservationInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReservationViewModel @Inject constructor(
    private val getReservationInfoUseCase: GetReservationInfoUseCase
) : ViewModel() {

    private val _reservationState = MutableStateFlow(ReservationState())
    val reservationState = _reservationState.asStateFlow()

    init {
        getRoomReservation()
    }
    private fun getRoomReservation() {
        viewModelScope.launch {
            getReservationInfoUseCase().collect { resource ->
                when(resource) {
                    is Resource.Error -> {
                        _reservationState.update {
                            it.copy(
                                error = resource.message,
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Success -> {
                        _reservationState.update {
                            it.copy(
                                reservation = resource.data,
                                isLoading = false
                            )
                        }
                    }
                }
            }
        }
    }
}