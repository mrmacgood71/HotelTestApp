package it.macgood.hotelapp.room.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import it.macgood.core_ui.CustomColor.PeculiaritiesOnSurface
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.hotelapp.domain.model.Room
@Composable
fun PriceRow(
    room: Room
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "${priceDelimiter(room.price.toString())} ₽ ",
            fontFamily = SfProDisplay,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,

            )
        Text(
            text = room.pricePer,
            fontFamily = SfProDisplay,
            color = PeculiaritiesOnSurface,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        )
    }
}

private fun priceDelimiter(price: String): String {
    return price.chunked(3) { it }.joinToString(" ")
}