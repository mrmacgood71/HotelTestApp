package it.macgood.hotelapp.reservation.component.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.macgood.core_ui.CustomColor.BackgroundColor
import it.macgood.core_ui.CustomColor.PeculiaritiesOnSurface
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.hotelapp.R
import it.macgood.hotelapp.hotel.DefaultCard
import it.macgood.hotelapp.reservation.component.view.PhoneTextField
import it.macgood.hotelapp.reservation.component.view.ReservationTextField

@Composable
fun InformationAboutCustomer() {

    var emailTemplate by remember { mutableStateOf<String?>(null) }
    var color by remember { mutableStateOf(BackgroundColor) }
    val focusRequester = remember { FocusRequester() }

    DefaultCard(
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(R.string.consumer_info),
                fontFamily = SfProDisplay,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            PhoneTextField()

            ReservationTextField(
                unfocusedContainerColor = color,
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .onFocusChanged {
                        if (it.isFocused) {
                            color = BackgroundColor
                            Log.d("TAG", "InformationAboutCustomer: isCaptured")
                        } else {
                            if (emailTemplate != null && emailTemplate?.isValidEmail() == false) {
                                color = Color(0x26EB5757)
                                Log.d("TAG", "InformationAboutCustomer: NE isCaptured")
                            }
                        }
                    },
                value = emailTemplate ?: "",
                resId = R.string.email
            ) { emailTemplate = it }

            Text(
                text = stringResource(R.string.consumer_info_disclamer),
                fontFamily = SfProDisplay,
                fontSize = 16.sp,
                color = PeculiaritiesOnSurface
            )
        }
    }
}

fun String.isValidEmail(): Boolean {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.(com|ru|[A-Za-z]+)\$"
    return this.matches(emailRegex.toRegex())
}