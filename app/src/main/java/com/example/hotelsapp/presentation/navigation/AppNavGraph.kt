package com.example.hotelsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hotelsapp.presentation.hotel_details.HotelDetailsScreen
import com.example.hotelsapp.presentation.hotel_details.HotelDetailsViewModel
import com.example.hotelsapp.presentation.hotel_list.HotelListScreen
import com.example.hotelsapp.presentation.hotel_list.HotelListViewModel


@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "hotel_list"
    ) {
        composable("hotel_list") {
            val viewModel: HotelListViewModel = hiltViewModel()
            HotelListScreen(
                viewModel = viewModel,
                onHotelClick = { hotelId ->
                    navController.navigate("hotel_details/$hotelId")
                }
            )
        }

        composable(
            route = "hotel_details/{hotelId}",
            arguments = listOf(navArgument("hotelId") { type = NavType.StringType })
        ) {
            val viewModel: HotelDetailsViewModel = hiltViewModel()
            HotelDetailsScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
