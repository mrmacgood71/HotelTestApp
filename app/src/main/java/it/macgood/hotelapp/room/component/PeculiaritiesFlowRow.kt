package it.macgood.hotelapp.room.component

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.macgood.core_ui.CustomColor.AddressColor
import it.macgood.core_ui.CustomColor.AddressColorLowAlpha
import it.macgood.core_ui.CustomColor.PeculiaritiesBackground
import it.macgood.core_ui.CustomColor.PeculiaritiesOnSurface
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.hotelapp.R
import it.macgood.hotelapp.domain.model.Room

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PeculiaritiesFlowRow(
    room: Room
) {
    FlowRow(modifier = Modifier.fillMaxWidth()) {
        repeat(room.peculiarities.size) {
            AssistChip(
                colors = AssistChipDefaults.assistChipColors(containerColor = PeculiaritiesBackground),
                border = null,
                onClick = { },
                label = {
                    Text(
                        text = room.peculiarities[it],
                        fontFamily = SfProDisplay,
                        fontSize = 16.sp,
                        color = PeculiaritiesOnSurface
                    )
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
        }

        AssistChip(
            colors = AssistChipDefaults.assistChipColors(containerColor = AddressColorLowAlpha),
            border = null,
            onClick = { },
            label = {
                Text(
                    text = "Подробнее о номере",
                    fontFamily = SfProDisplay,
                    fontSize = 16.sp,
                    color = AddressColor
                )
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = null,
                    tint = AddressColor
                )
            }
        )
    }
}