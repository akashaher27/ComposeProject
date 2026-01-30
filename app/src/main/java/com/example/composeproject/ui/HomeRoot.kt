package com.example.composeproject.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.core.Navigation.Destinations
import com.example.home.ui.HomeRoutes
import com.example.moviefeature.presenter.MovieRoutes


@Composable
fun HomeRoot(navController: NavHostController, destinations: Set<Destinations>) {

    Scaffold() { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = MovieRoutes.ROOT,
            modifier = Modifier
                .padding(paddingValues)
        ) {

            destinations.forEach { destination ->
                with(destination) { create(navController) }
            }
        }
    }
}