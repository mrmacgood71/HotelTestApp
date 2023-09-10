package it.macgood.presentation.reservation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import it.macgood.core_ui.CustomColor.BackgroundColor
import it.macgood.core_ui.R
import it.macgood.core_ui.view.DefaultTopBar
import it.macgood.presentation.reservation.component.screen.FinalPriceCard
import it.macgood.presentation.reservation.component.screen.HotelInfo
import it.macgood.presentation.reservation.component.screen.InformationAboutCustomer
import it.macgood.presentation.reservation.component.screen.ReservationDetailsTable
import it.macgood.presentation.reservation.component.screen.TouristCard
import it.macgood.presentation.reservation.component.screen.UnfoldTouristCard
import it.macgood.presentation.reservation.component.view.PayButton
import it.macgood.reservation.domain.model.RoomReservation
import it.macgood.reservation.domain.model.Tourist


@Composable
fun ReservationScreen(
    reservationViewModel: ReservationViewModel = hiltViewModel(),
    navController: NavController,
    onNavigate: () -> Unit
) {
    val reservationState = reservationViewModel.reservationState.collectAsState().value

    when {
        reservationState.isLoading -> {
            CircularProgressIndicator(Modifier.fillMaxSize())
        }

        reservationState.error != null -> {
            Text(modifier = Modifier.fillMaxSize(), text = reservationState.error)
        }

        reservationState.reservation != null -> {
            SuccessReservationScreen(
                navController = navController,
                reservation = reservationState.reservation,
                onNavigate = onNavigate
            )
        }
    }
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun SuccessReservationScreen(
    navController: NavController,
    reservation: RoomReservation,
    onNavigate: () -> Unit
) {
    val touristsCount = stringArrayResource(id = R.array.tourists)
    var id by remember { mutableIntStateOf(0) }
    val tourists = remember { mutableStateListOf(Tourist(id = id++), Tourist(id = id++)) }
    var price by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = {
            DefaultTopBar(
                titleText = stringResource(id = R.string.reservation),
                navIcon = painterResource(id = R.drawable.ic_arrow_right),
                navController = navController
            )
        }
    ) { innerPaddings ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor)
                .padding(innerPaddings),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                HotelInfo(reservation)
                Spacer(modifier = Modifier.height(8.dp))
                ReservationDetailsTable(reservation)
                Spacer(modifier = Modifier.height(8.dp))
                InformationAboutCustomer()
            }

            items(tourists, key = { it.id }) { tourist ->
                TouristCard(
                    modifier = Modifier.animateItemPlacement(
                        tween(
                            durationMillis = 500,
                            easing = LinearEasing
                        )
                    ),
                    touristCount =
                    if (id <= 10) touristsCount[tourists.lastIndexOf(tourist)]
                    else stringResource(
                        id = R.string.tourist_count_stub,
                        (tourist.id + 1).toString()
                    ),
                    tourist = tourist
                )
            }
            item { UnfoldTouristCard { tourists.add(Tourist(id = id++)) } }
            item {
                FinalPriceCard(reservation) {
                    price =
                        (reservation.tourPrice + reservation.fuelCharge + reservation.serviceCharge)
                    return@FinalPriceCard price
                }
            }
            item { PayButton(price = price, onNavigate = onNavigate) }
        }
    }
}







