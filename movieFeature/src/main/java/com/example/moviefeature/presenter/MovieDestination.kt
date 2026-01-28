package com.example.moviefeature.presenter


import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.core.Navigation.Destinations

class MovieDestination() : Destinations {
    override fun NavGraphBuilder.create(navController: NavController) {
        navigation(
            route = MovieRoutes.ROOT,
            startDestination = MovieRoutes.MOVIE_LIST
        ) {
            movieListScreen()
        }
    }

    private fun NavGraphBuilder.movieListScreen() {
        composable(
            route = MovieRoutes.MOVIE_LIST
        ) {

            MovieScreen() { }
        }
    }
}

