package it.macgood.hotelapp.room.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.hotelapp.R
import it.macgood.hotelapp.room.RoomsState

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun RoomTopBar(
    roomsState: RoomsState,
    navController: NavController
) {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = roomsState.hotelName ?: stringResource(id = R.string.hotel),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = SfProDisplay,
                fontSize = 18.sp
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
        navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    modifier = Modifier
                        .rotate(180f)
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = null
                )
            }
        }
    )
}