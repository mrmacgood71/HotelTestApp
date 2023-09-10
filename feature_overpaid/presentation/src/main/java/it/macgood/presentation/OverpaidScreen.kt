package it.macgood.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import it.macgood.core_ui.CustomColor.BackgroundColor
import it.macgood.core_ui.CustomColor.PeculiaritiesOnSurface
import it.macgood.core_ui.Fonts
import it.macgood.core_ui.R
import it.macgood.core_ui.view.DefaultTopBar
import it.macgood.core_ui.view.SingleButtonBottomBar

@Composable
fun OverpaidScreen(
    navController: NavController,
    onNavigate: () -> Unit
) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                titleText = stringResource(R.string.order_paid),
                navIcon = painterResource(id = R.drawable.ic_arrow_right),
                navController = navController
            )
        },
        bottomBar = {
            SingleButtonBottomBar(
                buttonText = stringResource(R.string.overpaid_super),
                onNavigate = onNavigate
            )
        }
    ) { innerPaddings ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
                .padding(innerPaddings),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .size(96.dp)
                .background(BackgroundColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(id = R.drawable.ic_party_popper),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.order_in_progress),
                textAlign = TextAlign.Center,
                fontFamily = Fonts.SfProDisplay,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.order_in_progress_sub),
                textAlign = TextAlign.Center,
                fontFamily = Fonts.SfProDisplay,
                color = PeculiaritiesOnSurface,
                fontSize = 16.sp
            )
        }
    }
}