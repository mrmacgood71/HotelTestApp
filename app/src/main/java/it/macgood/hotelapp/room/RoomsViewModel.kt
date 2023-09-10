package it.macgood.hotelapp.room

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.macgood.core.Resource
import it.macgood.hotelapp.domain.usecase.GetRoomsUseCase
import it.macgood.hotelapp.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(
    private val getRoomsUseCase: GetRoomsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _roomState = MutableStateFlow(RoomsState())
    val roomsState = _roomState.asStateFlow()

    init {
        _roomState.update {
            it.copy(
                hotelName = savedStateHandle.get<String>(Screen.HOTEL_NAME)
            )
        }
        getRooms()
    }

    private fun getRooms() {
        viewModelScope.launch {
            getRoomsUseCase().collect { resource ->
                when(resource) {
                    is Resource.Error -> {
                        _roomState.update {
                            it.copy(
                                error = resource.message,
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Success -> {
                        _roomState.update {
                            it.copy(
                                rooms = resource.data,
                                isLoading = false
                            )
                        }
                    }
                }
            }
        }
    }
}