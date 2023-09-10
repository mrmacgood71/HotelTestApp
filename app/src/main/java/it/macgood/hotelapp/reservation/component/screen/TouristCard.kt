package it.macgood.hotelapp.reservation.component.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.macgood.core_ui.CustomColor.AddressColor
import it.macgood.core_ui.CustomColor.AddressColorLowAlpha
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.hotelapp.R
import it.macgood.hotelapp.domain.model.Tourist
import it.macgood.hotelapp.hotel.DefaultCard
import it.macgood.hotelapp.reservation.component.view.ReservationTextField

@Composable
fun TouristCard(
    modifier: Modifier = Modifier,
    touristCount: String,
    tourist: Tourist
) {
    var expandedState by remember {
        mutableStateOf(false)
    }
    val state = remember {
        mutableStateOf(tourist)
    }
    val angle by animateFloatAsState(
        targetValue = if (expandedState) 90f else 270f, label = ""
    )

    DefaultCard(
        modifier = modifier.animateContentSize(
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearOutSlowInEasing
            )
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = touristCount,
                    fontFamily = SfProDisplay,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                IconButton(
                    modifier = Modifier
                        .background(AddressColorLowAlpha, RoundedCornerShape(8.dp))
                        .size(32.dp),
                    onClick = {
                        expandedState = !expandedState
                    }
                ) {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .rotate(angle),
                        tint = AddressColor,
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null
                    )
                }
            }
            if (expandedState) {
                ExpandedContent(state)
            }
        }
    }
}

@Composable
private fun ExpandedContent(state: MutableState<Tourist>) {
    ReservationTextField(
        value = state.value.firstname,
        resId = R.string.firstname
    ) {
        state.value = state.value.copy(firstname = it)
    }
    ReservationTextField(
        value = state.value.lastname,
        resId = R.string.lastname
    ) {
        state.value = state.value.copy(lastname = it)
    }
    ReservationTextField(
        value = state.value.dateOfBirth,
        resId = R.string.dateOfBirth
    ) {
        state.value = state.value.copy(dateOfBirth = it)
    }
    ReservationTextField(
        value = state.value.citizenship,
        resId = R.string.citizenship
    ) {
        state.value = state.value.copy(citizenship = it)
    }
    ReservationTextField(
        value = state.value.foreignPassportNumber,
        resId = R.string.foreignPassportNumber
    ) {
        state.value = state.value.copy(foreignPassportNumber = it)
    }
    ReservationTextField(
        value = state.value.foreignPassportValidityPeriod,
        resId = R.string.foreignPassportValidityPeriod
    ) {
        state.value = state.value.copy(foreignPassportValidityPeriod = it)
    }
}

@Composable
fun UnfoldTouristCard(
    onClick: () -> Unit
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.add_tourist),
                    fontFamily = SfProDisplay,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                IconButton(
                    modifier = Modifier
                        .background(AddressColor, RoundedCornerShape(8.dp))
                        .clickable(
                            indication = null,
                            interactionSource = MutableInteractionSource()
                        ) {
                        }
                        .size(32.dp),
                    onClick = onClick
                ) {
                    Icon(
                        modifier = Modifier
                            .size(24.dp),
                        tint = Color.White,
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = null
                    )
                }
            }
        }
    }
}
