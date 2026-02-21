package com.example.moviefeature.presenter


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
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
        composable(
            route = MovieRoutes.MOVIE_LIST
        ) {
            val viewModel = viewModel { movieComponent.movieViewModel() }
            val uiState by viewModel.uiState.collectAsState()
            MovieScreen(
                uiState = uiState

            ) { event ->
                viewModel.onMovieEvent(event)
            }
        }
    }
}

