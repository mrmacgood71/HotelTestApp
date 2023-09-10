package it.macgood.presentation.hotel.component

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import it.macgood.core_ui.CustomColor.PeculiaritiesBackground
import it.macgood.core_ui.CustomColor.PeculiaritiesOnSurface
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.hotel.domain.Hotel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PeculiaritiesFlowRow(
    hotel: Hotel
) {
    FlowRow(modifier = Modifier.fillMaxWidth()) {
        repeat(hotel.aboutTheHotel.peculiarities.size) {
            AssistChip(
                colors = AssistChipDefaults.assistChipColors(containerColor = PeculiaritiesBackground),
                border = null,
                onClick = { },
                label = {
                    Text(
                        text = hotel.aboutTheHotel.peculiarities[it],
                        fontFamily = SfProDisplay,
                        fontSize = 16.sp,
                        color = PeculiaritiesOnSurface
                    )
                }
            )
        }
    }
}