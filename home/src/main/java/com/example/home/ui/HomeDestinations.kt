package com.example.home.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.core.Navigation.Destinations
import com.example.home.di.HomeComponent
import com.example.home.ui.internal.dashboard.DashBoardScreen
import com.example.home.ui.internal.dashboard.plugin.WelcomeBannerPlugin

class HomeDestinations(
    private val homeComponent: HomeComponent
) : Destinations {
    override fun NavGraphBuilder.create(navController: NavController) {
        navigation(
            route = HomeRoutes.ROOT,
            startDestination = HomeRoutes.DASHBOARD
        ) {
            dashBoardScreen()
        }
    }

    private fun NavGraphBuilder.dashBoardScreen() {
        composable(
            route = HomeRoutes.DASHBOARD,
        ) {
            val homePlugin = listOf(
                WelcomeBannerPlugin(homeComponent.welcomeBannerViewModel())
            )
            val viewModel = homeComponent.dashBoardViewModel()
            viewModel.initPlugin(homePlugin)
            DashBoardScreen(viewModel)
        }
    }
}