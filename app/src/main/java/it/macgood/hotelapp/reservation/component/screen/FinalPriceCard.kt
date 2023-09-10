package it.macgood.hotelapp.reservation.component.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import it.macgood.core.Utils
import it.macgood.core_ui.CustomColor.AddressColor
import it.macgood.hotelapp.R
import it.macgood.hotelapp.domain.model.RoomReservation
import it.macgood.hotelapp.hotel.DefaultCard

@Composable
fun FinalPriceCard(
    reservation: RoomReservation,
    onCountPrice: () -> Int
) {
    DefaultCard(
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ReservationFinalPriceDetails(
                label = stringResource(R.string.tour),
                value = stringResource(
                    id = R.string.any_price_value,
                    Utils.priceDelimiter(reservation.tourPrice.toString())

                )

            )
            ReservationFinalPriceDetails(
                label = stringResource(R.string.fuel_surcharge),
                value = stringResource(
                    id = R.string.any_price_value,
                    Utils.priceDelimiter(reservation.fuelCharge.toString())

                )

            )
            ReservationFinalPriceDetails(
                label = stringResource(R.string.service_charge),
                value = stringResource(
                    id = R.string.any_price_value,
                    Utils.priceDelimiter(reservation.serviceCharge.toString())

                )
            )
            ReservationFinalPriceDetails(
                textColor = AddressColor,
                label = stringResource(R.string.to_pay),
                value = stringResource(
                    id = R.string.any_price_value,
                    Utils.priceDelimiter(onCountPrice().toString())
                )
            )
        }
    }
}