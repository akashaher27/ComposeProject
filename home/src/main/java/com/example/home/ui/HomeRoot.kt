package com.example.home.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.core.Navigation.Destinations


@Composable
internal fun HomeRoot(navController: NavHostController, destinations: Set<Destinations>) {

    Scaffold() { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = HomeRoutes.ROOT,
            modifier = Modifier
                .padding(paddingValues)
        ) {

            destinations.forEach { destination ->
                with(destination) { create(navController) }
            }
        }
    }
}