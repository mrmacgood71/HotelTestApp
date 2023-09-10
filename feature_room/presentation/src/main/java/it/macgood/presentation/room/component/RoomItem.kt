package it.macgood.presentation.room.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.macgood.core_ui.CustomColor.AddressColor
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.core_ui.GradientButton
import it.macgood.core_ui.R
import it.macgood.core_ui.view.DefaultCard
import it.macgood.core_ui.view.ImageCarousel
import it.macgood.room.domain.model.Room

@Composable
fun RoomItem(
    modifier: Modifier = Modifier,
    onNavigate: () -> Unit,
    room: Room
) {
    DefaultCard(
        shape = RoundedCornerShape(
            bottomStart = 8.dp,
            bottomEnd = 8.dp
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ImageCarousel(images = room.imageUrls)
            Text(
                text = room.name,
                fontFamily = SfProDisplay,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            PeculiaritiesFlowRow(room = room)
            PriceRow(room = room)
            GradientButton(
                modifier = Modifier.height(48.dp),
                text = stringResource(R.string.chose_room),
                containerColor = AddressColor,
                onClick = onNavigate
            )
        }
    }
}