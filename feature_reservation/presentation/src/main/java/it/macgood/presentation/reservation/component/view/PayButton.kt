package it.macgood.presentation.reservation.component.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import it.macgood.core.Utils
import it.macgood.core_ui.CustomColor.AddressColor
import it.macgood.core_ui.R
import it.macgood.core_ui.view.DefaultCard

@Composable
fun PayButton(
    price: Int,
    onNavigate: () -> Unit
) {
    DefaultCard(
        shape = RoundedCornerShape(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Divider()
            it.macgood.core_ui.GradientButton(
                modifier = Modifier
                    .height(48.dp)
                    .padding(horizontal = 8.dp),
                text =
                stringResource(
                    R.string.to_pay_summ,
                    Utils.priceDelimiter(price.toString())
                ),
                onClick = onNavigate,
                containerColor = AddressColor
            )
        }
    }
}