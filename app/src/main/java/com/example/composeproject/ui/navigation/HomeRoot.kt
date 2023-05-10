package com.example.composeproject.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.composeproject.ui.navigation.home.HomeRoute
import com.example.core.Navigation.Destinations


@Composable
internal fun HomeRoot(navController: NavHostController, destination: Set<Destinations>) {

    NavHost(
        navController = navController,
        startDestination = HomeRoute.ROOT
    ) {
        destination.forEach { destination ->
            with(destination) { create(navController) }
        }
    }
}