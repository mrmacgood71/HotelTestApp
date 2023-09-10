package it.macgood.presentation.hotel.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import it.macgood.core_ui.CustomColor.AddressColor
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.core_ui.GradientButton
import it.macgood.core_ui.R
import it.macgood.hotel.domain.Hotel


@Composable
fun HotelBottomBar(
    hotel: Hotel,
    onNavigate: (Hotel) -> Unit = {}
) {
    BottomAppBar(
        modifier = Modifier
            .height(96.dp),
        containerColor = Color.White,
        contentColor = Color.Black,
        tonalElevation = 8.dp
    ) {
        GradientButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .height(48.dp),
            onClick = { onNavigate(hotel) },
            text = stringResource(R.string.to_choose_room),
            containerColor = AddressColor
        )
    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HotelTopBar() {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
        title = {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.hotel),
                textAlign = TextAlign.Center,
                fontFamily = SfProDisplay,
                fontSize = 18.sp
            )
        }
    )
}