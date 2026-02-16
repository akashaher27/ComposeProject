package com.example.moviefeature.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviefeature.domain.model.Movie
import com.example.moviefeature.domain.useCase.GetMovieUseCase
import com.example.moviefeature.domain.useCase.RefreshMovieUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase,
    private val refreshMovieUseCase: RefreshMovieUseCase
) : ViewModel() {

    val uiState: StateFlow<UiState> = getMovieUseCase()
        .map { movies ->
            if (movies.isEmpty()) UiState.Loading else UiState.Success(movies)
        }
        .catch {
            emit(UiState.Error("Failed to read local data"))
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UiState.Loading
        )

    init {
        refreshMovieList()
    }


    private fun refreshMovieList() {
        viewModelScope.launch {
            refreshMovieUseCase()
        }
    }

    fun onMovieEvent(event: MovieEvent) {
        when (event) {
            is MovieEvent.ShowMovieDetail -> {
                Log.d("TAG", "onMovieEvent: ${event.id}")
            }

            else -> Unit
        }
    }
}


sealed class UiState {
    object Loading : UiState()
    data class Success(val data: List<Movie>) : UiState()
    data class Error(val message: String) : UiState()

}

sealed class MovieEvent {
    data class ShowMovieDetail(val id: String) : MovieEvent()
}
