package com.example.moviefeature.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.moviefeature.domain.model.Movie
import com.example.ui_common.cream.components.AppScaffold
import com.example.ui_common.cream.foundation.AppTheme
import com.example.ui_common.ui.common.theme.grid_x1
import com.example.ui_common.ui.common.theme.grid_x16
import com.example.ui_common.ui.common.theme.grid_x2
import com.example.ui_common.ui.common.theme.grid_x8

@Composable
fun MovieScreen(
    uiState: UiState,
    onEvent: (MovieEvent) -> Unit
) {

    AppScaffold(
        modifier = Modifier
            .padding(horizontal = grid_x2),
    ) {
        when (uiState) {
            is UiState.Loading -> {
                loadingScreen()
            }

            is UiState.Success -> {
                movieList(uiState.data)
            }

            is UiState.Error -> {
                errorScreen()
            }
        }
    }


}

@Composable
private fun movieList(
    movies: List<Movie>
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(grid_x8)
        ) {
            items(movies) { movie ->
                movieItem(movie)
            }
        }
    }
}

@Composable
private fun movieItem(movie: Movie) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(movie.name)
        Text(movie.genre)
    }
}

@Composable
private fun loadingScreen() {
}

@Composable
private fun errorScreen() {
}

