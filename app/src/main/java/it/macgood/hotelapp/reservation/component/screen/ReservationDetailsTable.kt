package it.macgood.hotelapp.reservation.component.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.macgood.core_ui.CustomColor.PeculiaritiesOnSurface
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.hotelapp.R
import it.macgood.hotelapp.domain.model.RoomReservation
import it.macgood.hotelapp.hotel.DefaultCard

@Composable
fun ReservationDetailsTable(reservation: RoomReservation) {
    DefaultCard(
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ReservationDetails(
                label = stringResource(R.string.departure),
                value = reservation.departure
            )
            ReservationDetails(
                label = stringResource(R.string.country_city),
                value = reservation.arrivalCountry
            )
            ReservationDetails(
                label = stringResource(R.string.dates),
                value = stringResource(
                    R.string.dates_value,
                    reservation.tourDateStart,
                    reservation.tourDateStop
                )
            )
            ReservationDetails(
                label = stringResource(R.string.num_of_nights),
                value = stringResource(
                    id = R.string.num_of_nights_value,
                    reservation.numberOfNights
                )
            )
            ReservationDetails(
                label = stringResource(R.string.hotel),
                value = reservation.hotelName
            )
            ReservationDetails(
                label = stringResource(R.string.room),
                value = reservation.room
            )
            ReservationDetails(
                label = stringResource(R.string.nutrition),
                value = reservation.nutrition
            )
        }
    }
}

@Composable
fun ReservationDetails(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.weight(0.6f),
            text = label,
            fontFamily = SfProDisplay,
            fontSize = 16.sp,
            color = PeculiaritiesOnSurface
        )
        Text(
            modifier = Modifier.weight(1f),
            fontFamily = SfProDisplay,
            fontSize = 16.sp,
            color = Color.Black,
            text = value,
        )
    }
}

@Composable
fun ReservationFinalPriceDetails(
    textColor: Color = Color.Black,
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontFamily = SfProDisplay,
            fontSize = 16.sp,
            color = PeculiaritiesOnSurface
        )
        Text(
            fontFamily = SfProDisplay,
            fontSize = 16.sp,
            color = textColor,
            fontWeight = FontWeight.Bold,
            text = value,
        )
    }
}
