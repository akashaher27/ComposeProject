package com.example.moviefeature.presenter


import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.core.Navigation.Destinations
import com.example.moviefeature.data.di.MovieComponent

class MovieDestination : Destinations {

    override fun NavGraphBuilder.create(navController: NavController) {
        val movieComponent: MovieComponent by lazy {
            MovieComponent.build()
        }
        navigation(
            route = MovieRoutes.ROOT,
            startDestination = MovieRoutes.MOVIE_LIST
        ) {
            movieListScreen(movieComponent)
        }
    }

    private fun NavGraphBuilder.movieListScreen(movieComponent: MovieComponent) {
        val viewModel = movieComponent.movieViewModel()
        composable(
            route = MovieRoutes.MOVIE_LIST
        ) {
            MovieScreen() { event ->
                viewModel.onMovieEvent(event)
            }
        }
    }
}

