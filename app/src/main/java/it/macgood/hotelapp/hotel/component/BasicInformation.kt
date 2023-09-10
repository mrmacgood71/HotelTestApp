package it.macgood.hotelapp.hotel.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.macgood.core.Utils
import it.macgood.core_ui.CustomColor.AddressColor
import it.macgood.core_ui.CustomColor.PeculiaritiesOnSurface
import it.macgood.core_ui.CustomColor.RatingColorBackground
import it.macgood.core_ui.CustomColor.RatingColorOnSurface
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.hotelapp.R
import it.macgood.hotelapp.domain.model.Hotel


@Composable
fun BasicInformation(
    hotel: Hotel
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(bottom = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            HotelCarousel(images = hotel.imageUrls)
            RatingChip(
                rating = hotel.rating,
                ratingName = hotel.ratingName
            )
            Text(
                text = hotel.name,
                fontFamily = SfProDisplay,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Text(
                text = hotel.address,
                fontFamily = SfProDisplay,
                color = AddressColor,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )

            PriceRow(hotel)
        }
    }
}

@Composable
fun PriceRow(
    hotel: Hotel
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = stringResource(
                id = R.string.price_value,
                Utils.priceDelimiter(hotel.minimalPrice.toString())
            ),
            fontFamily = SfProDisplay,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
        )
        Text(
            text = hotel.priceForIt,
            fontFamily = SfProDisplay,
            color = PeculiaritiesOnSurface,
            fontSize = 16.sp,
        )
    }
}

@Composable
fun RatingChip(rating: Int, ratingName: String) {
    AssistChip(
        colors = AssistChipDefaults.assistChipColors(containerColor = RatingColorBackground),
        border = null,
        leadingIcon = {
            Icon(
                modifier = Modifier.size(15.dp),
                painter = painterResource(id = R.drawable.ic_star),
                tint = RatingColorOnSurface,
                contentDescription = null
            )
        },
        onClick = { },
        label = {
            Text(
                text = stringResource(
                    id = R.string.rating_value,
                    rating,
                    ratingName
                ),
                fontFamily = SfProDisplay,
                fontSize = 16.sp,
                color = RatingColorOnSurface
            )
        }
    )
}