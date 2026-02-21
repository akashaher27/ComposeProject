package com.example.home.ui

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.core.Navigation.Destinations
import com.example.home.ui.internal.di.HomeComponent
import com.example.home.ui.internal.ui.dashboard.DashBoardScreen
import com.example.home.ui.internal.ui.dashboard.DashBoardViewModel
import com.example.home.ui.internal.ui.dashboard.plugin.ForYouToday.ForYouTodayPlugin
import com.example.home.ui.internal.ui.dashboard.plugin.WelcomeBannerPlugin

class HomeDestinations(
) : Destinations {
    override fun NavGraphBuilder.create(navController: NavController) {
        val homeComponent: HomeComponent by lazy {
            HomeComponent.build()
        }
        navigation(
            route = HomeRoutes.ROOT,
            startDestination = HomeRoutes.DASHBOARD
        ) {
            dashBoardScreen(homeComponent)
        }
    }

    private fun NavGraphBuilder.dashBoardScreen(homeComponent: HomeComponent) {

        composable(
            route = HomeRoutes.DASHBOARD,
        ) {
            val dashBoardViewModel = viewModel { homeComponent.dashBoardViewModel() }
            val pluginViewModel = viewModel { homeComponent.pluginViewModel() }
            val welcomeBannerViewModel = viewModel { homeComponent.welcomeBannerViewModel() }
            val homePlugin = listOf(
                WelcomeBannerPlugin(welcomeBannerViewModel),
                ForYouTodayPlugin(pluginViewModel)
            )
            DashBoardScreen(dashBoardViewModel)
        }
    }
}