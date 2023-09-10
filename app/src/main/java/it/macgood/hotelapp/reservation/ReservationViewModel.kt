package it.macgood.hotelapp.reservation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.macgood.core.Resource
import it.macgood.hotelapp.domain.usecase.GetReservationInfoUseCase
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

    private val _event = MutableStateFlow<ReservationEvent>(ReservationEvent.None)
    val event = _event.asStateFlow()


    init {
        getRoomReservation()
    }

    fun onEvent(event: ReservationEvent) {
        when(event) {
            ReservationEvent.None -> TODO()
            is ReservationEvent.OnNumberChanged -> {

            }
        }
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