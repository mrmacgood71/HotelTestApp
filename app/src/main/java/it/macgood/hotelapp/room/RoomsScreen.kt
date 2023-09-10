package it.macgood.hotelapp.room

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import it.macgood.core_ui.CustomColor.BackgroundColor
import it.macgood.hotelapp.room.component.RoomItem
import it.macgood.hotelapp.room.component.RoomTopBar

@Composable
fun RoomsScreen(
    navController: NavController,
    roomsViewModel: RoomsViewModel = hiltViewModel()
) {

    val roomsState = roomsViewModel.roomsState.collectAsState().value

    when {
        roomsState.isLoading -> CircularProgressIndicator(Modifier.fillMaxSize())
        roomsState.error != null -> Text(text = roomsState.error)
        else -> {
            Scaffold(
                topBar = {
                    RoomTopBar(roomsState, navController)
                }
            ) { innerPaddings ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPaddings)
                        .background(BackgroundColor)
                ) {
                    items(roomsState.rooms) {
                        Spacer(modifier = Modifier.height(8.dp))
                        RoomItem(
                            room = it,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}


