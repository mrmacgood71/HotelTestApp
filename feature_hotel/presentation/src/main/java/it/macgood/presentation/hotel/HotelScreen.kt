package it.macgood.presentation.hotel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import it.macgood.core_ui.CustomColor.BackgroundColor
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.core_ui.R
import it.macgood.core_ui.view.DefaultCard
import it.macgood.hotel.domain.Hotel
import it.macgood.presentation.hotel.component.AmenitiesColumn
import it.macgood.presentation.hotel.component.BasicInformation
import it.macgood.presentation.hotel.component.HotelBottomBar
import it.macgood.presentation.hotel.component.HotelTopBar
import it.macgood.presentation.hotel.component.IconsColumn
import it.macgood.presentation.hotel.component.PeculiaritiesFlowRow

@Composable
fun HotelScreen(
    hotelViewModel: HotelViewModel = hiltViewModel(),
    onNavigate: (Hotel) -> Unit = {}
) {
    val hotelState = hotelViewModel.hotel.collectAsState().value

    when {
        hotelState.isLoading -> {
            CircularProgressIndicator(Modifier.fillMaxSize())
        }

        hotelState.error != null -> {
            Text(text = hotelState.error)
        }

        hotelState.hotel != null -> {
            Scaffold(
                topBar = { HotelTopBar() },
                bottomBar = {
                    HotelBottomBar(
                        hotel = hotelState.hotel,
                        onNavigate = onNavigate
                    )
                }
            ) { innerPaddings ->
                LoadedHotelScreen(innerPaddings, hotelState.hotel)
            }
        }
    }
}

@Composable
private fun LoadedHotelScreen(
    innerPaddings: PaddingValues,
    hotel: Hotel
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(innerPaddings)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        DefaultCard(
            shape = RoundedCornerShape(
                bottomStart = 8.dp,
                bottomEnd = 8.dp
            )
        ) {
            BasicInformation(hotel)
        }
        DefaultCard(Modifier.padding(bottom = 8.dp)) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.about_hotel),
                    fontFamily = SfProDisplay,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

                PeculiaritiesFlowRow(hotel)
                Text(
                    modifier = Modifier.alpha(0.9f),
                    text = hotel.aboutTheHotel.description,
                    fontFamily = SfProDisplay,
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BackgroundColor, RoundedCornerShape(16.dp))
                        .padding(12.dp)
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconsColumn()
                        AmenitiesColumn()
                    }
                }
            }
        }
    }
}

