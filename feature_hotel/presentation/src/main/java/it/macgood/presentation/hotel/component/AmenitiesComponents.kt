package it.macgood.presentation.hotel.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.macgood.core_ui.CustomColor.PeculiaritiesOnSurface
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.core_ui.R

@Composable
fun AmenitiesColumn() {
    Column {
        AmenitiesRow(
            text = stringResource(R.string.comforts),
            description = stringResource(id = R.string.most_important)
        )
        Divider(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp, end = 24.dp)
        )
        AmenitiesRow(
            text = stringResource(R.string.what_is_included),
            description = stringResource(id = R.string.most_important)
        )
        Divider(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp, end = 24.dp)
        )
        AmenitiesRow(
            text = stringResource(R.string.what_is_not_included),
            description = stringResource(id = R.string.most_important)
        )
    }
}

@Composable
fun IconsColumn() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
            .padding(end = 4.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(id = R.drawable.ic_emoji_happy),
            contentDescription = null
        )
        Icon(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(id = R.drawable.ic_tick_square),
            contentDescription = null
        )
        Icon(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(id = R.drawable.ic_close_square),
            contentDescription = null
        )
    }
}

@Composable
fun AmenitiesRow(
    text: String,
    description: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = text,
                fontFamily = SfProDisplay,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = description,
                fontFamily = SfProDisplay,
                color = PeculiaritiesOnSurface,
                fontSize = 16.sp
            )
        }
        Icon(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null
        )
    }
}
