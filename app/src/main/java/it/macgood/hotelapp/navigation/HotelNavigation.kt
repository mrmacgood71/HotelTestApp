package it.macgood.hotelapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import it.macgood.core_ui.CustomTransition
import it.macgood.hotelapp.hotel.HotelScreen
import it.macgood.hotelapp.orderpaid.OverpaidScreen
import it.macgood.hotelapp.reservation.ReservationScreen
import it.macgood.hotelapp.room.RoomsScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HotelNavigation() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(navController = navController, startDestination = Screen.HotelScreen.route) {
        composable(
            route = Screen.HotelScreen.route,
            arguments = Screen.HotelScreen.arguments,
            enterTransition = { it.macgood.core_ui.CustomTransition.enterTransition() },
            exitTransition = { it.macgood.core_ui.CustomTransition.exitTransition() },
            popEnterTransition = { it.macgood.core_ui.CustomTransition.popEnterTransition() },
            popExitTransition = { it.macgood.core_ui.CustomTransition.popExitTransition() }
        ) {
            HotelScreen(navController = navController)
        }
        composable(
            route = "${Screen.RoomsScreen.route}/{${Screen.HOTEL_NAME}}",
            arguments = Screen.RoomsScreen.arguments,
            enterTransition = { it.macgood.core_ui.CustomTransition.enterTransition() },
            exitTransition = { it.macgood.core_ui.CustomTransition.exitTransition() },
            popEnterTransition = { it.macgood.core_ui.CustomTransition.popEnterTransition() },
            popExitTransition = { it.macgood.core_ui.CustomTransition.popExitTransition() }
        ) {
            RoomsScreen(navController = navController)
        }
        composable(
            route = Screen.ReservationScreen.route,
            arguments = Screen.ReservationScreen.arguments,
            enterTransition = { it.macgood.core_ui.CustomTransition.enterTransition() },
            exitTransition = { it.macgood.core_ui.CustomTransition.exitTransition() },
            popEnterTransition = { it.macgood.core_ui.CustomTransition.popEnterTransition() },
            popExitTransition = { it.macgood.core_ui.CustomTransition.popExitTransition() }
        ) {
            ReservationScreen(navController = navController)
        }
        composable(
            route = Screen.OverpaidScreen.route,
            arguments = Screen.OverpaidScreen.arguments,
            enterTransition = { it.macgood.core_ui.CustomTransition.enterTransition() },
            exitTransition = { it.macgood.core_ui.CustomTransition.exitTransition() },
            popEnterTransition = { it.macgood.core_ui.CustomTransition.popEnterTransition() },
            popExitTransition = { it.macgood.core_ui.CustomTransition.popExitTransition() }
        ) {
            OverpaidScreen(navController = navController)
        }

    }


}

sealed class Screen(
    val route: String, val arguments: List<NamedNavArgument>
) {
    object HotelScreen : Screen("hotel_screen", emptyList())
    object RoomsScreen : Screen("rooms_screen", listOf(
        navArgument(
            name = HOTEL_NAME
        ) {
            type = NavType.StringType
        }
    )) {
        fun createRoute(hotelName: String) = "${this.route}/${hotelName}"
    }
    object ReservationScreen : Screen("reservation_screen", emptyList())
    object OverpaidScreen : Screen("overpaid_screen", emptyList())

    companion object {
        const val HOTEL_NAME = "hotel_name"
    }
}