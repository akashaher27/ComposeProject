package com.example.composeproject.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.composeproject.ui.navigation.auth.AuthRoute
import com.example.composeproject.ui.navigation.home.HomeRoute


@Composable
internal fun HomeRoot(navController: NavHostController, destination: Set<Destination>) {

    NavHost(
        navController = navController,
        startDestination = HomeRoute.ROOT
    ) {
        destination.forEach { destination ->
            with(destination) { create(navController) }
        }
    }
}