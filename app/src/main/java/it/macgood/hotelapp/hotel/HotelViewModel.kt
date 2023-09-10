package it.macgood.hotelapp.hotel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.macgood.core.Resource
import it.macgood.hotelapp.domain.usecase.GetHotelUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(
  private val getHotelUseCase: GetHotelUseCase
) : ViewModel() {
    private val _hotel = MutableStateFlow(HotelState())
    val hotel = _hotel.asStateFlow()

    init {
        getHotel()
    }

    private fun getHotel() {
        viewModelScope.launch {
            getHotelUseCase().collect { resource ->
                when(resource) {
                    is Resource.Error -> {
                        _hotel.update {
                            it.copy(
                                hotel = resource.data,
                                isLoading = false,
                                error = resource.message
                            )
                        }
                    }
                    is Resource.Success -> {
                        _hotel.update {
                            it.copy(
                                hotel = resource.data,
                                isLoading = false
                            )
                        }
                    }
                }
            }
        }
    }
}