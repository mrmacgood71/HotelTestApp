package it.macgood.presentation.reservation.component.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.macgood.core_ui.CustomColor.AddressColor
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.core_ui.view.DefaultCard
import it.macgood.core_ui.view.RatingChip
import it.macgood.reservation.domain.model.RoomReservation

@Composable
fun HotelInfo(reservation: RoomReservation) {
    DefaultCard(
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            RatingChip(
                ratingName = reservation.ratingName,
                rating = reservation.hotelRating
            )
            Text(
                text = reservation.hotelName,
                fontFamily = SfProDisplay,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Text(
                text = reservation.hotelAddress,
                fontFamily = SfProDisplay,
                color = AddressColor,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
    }
}