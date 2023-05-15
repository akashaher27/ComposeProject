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
    Scaffold { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = HomeRoutes.ROOT
        ) {
            destinations.forEach { destination ->
                with(destination) { create(navController) }
            }
        }
    }
}