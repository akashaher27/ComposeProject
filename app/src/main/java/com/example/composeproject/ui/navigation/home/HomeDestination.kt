package com.example.composeproject.ui.navigation.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.core.Navigation.Destinations

class HomeDestination() : Destinations {

    override fun NavGraphBuilder.create(navController: NavController) {
        navigation(
            startDestination = HomeRoute.openDashBoard(),
            route = HomeRoute.ROOT
        ) {
            dashBoardScreen()
        }
    }

    private fun NavGraphBuilder.dashBoardScreen() {
        composable(
            route = HomeRoute.DASHBOARD
        ) {
        }
    }

}