package it.macgood.presentation.reservation.component.view

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.macgood.core_ui.CustomColor.BackgroundColor
import it.macgood.core_ui.CustomColor.PeculiaritiesOnSurface
import it.macgood.core_ui.Fonts.SfProDisplay
import it.macgood.core_ui.R

@Composable
fun ReservationTextField(
    focusedContainerColor: Color = BackgroundColor,
    unfocusedContainerColor: Color = BackgroundColor,
    modifier: Modifier = Modifier,
    value: String,
    @StringRes resId: Int,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(
                text = stringResource(id = resId),
                fontFamily = SfProDisplay
            )
        },
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = focusedContainerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = PeculiaritiesOnSurface,
            unfocusedContainerColor = unfocusedContainerColor,
            unfocusedLabelColor = PeculiaritiesOnSurface
        ),
        shape = RoundedCornerShape(8.dp),
        textStyle = TextStyle.Default.copy(
            fontFamily = SfProDisplay,
            color = Color.Black,
            fontSize = 16.sp
        )
    )
}

@Composable
fun PhoneTextField() {
    var numberTemplate by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = numberTemplate,
        onValueChange = { it ->
            numberTemplate = it.filter { it.isDigit() }.take(10)
        },
        label = {
            Text(
                text = stringResource(id = R.string.phone_number),
                fontFamily = SfProDisplay
            )
        },
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = BackgroundColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = PeculiaritiesOnSurface,
            unfocusedContainerColor = BackgroundColor,
            unfocusedLabelColor = PeculiaritiesOnSurface
        ),
        shape = RoundedCornerShape(8.dp),
        textStyle = TextStyle.Default.copy(
            fontFamily = SfProDisplay,
            fontSize = 16.sp
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        visualTransformation = MaskTransformation()
    )
}


class MaskTransformation() : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return maskFilter(text)
    }
}


fun maskFilter(text: AnnotatedString): TransformedText {
    val maxPhoneLength = 10
    val filteredText = text.text.take(maxPhoneLength)
    val out = StringBuilder("+7 (***) ***-**-** ")

    for (i in filteredText.indices) {
        out[i + when (i) {
            in 0..2 -> 4
            in 3..5 -> 6
            in 6..7 -> 7
            in 8..9 -> 8
            else -> 5
        }] = filteredText[i]
    }

    val numberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when (filteredText.length) {
                in 4..6 -> filteredText.length + 7
                in 7..8 -> filteredText.length + 8
                in 9..10 -> filteredText.length + 9
                else -> filteredText.length + 5
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return filteredText.length
        }
    }

    return TransformedText(AnnotatedString(out.toString()), numberOffsetTranslator)
}
