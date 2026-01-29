package com.example.moviefeature.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviefeature.domain.model.Movie
import com.example.moviefeature.domain.useCase.GetMovieUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel  @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiState = _uiState.asStateFlow()


    private fun getMovieList() {
        viewModelScope.launch {
            getMovieUseCase()
                .onSuccess { response ->
                    _uiState.update { UiState.Success(response) }
                }
                .onFailure {
                    _uiState.update { UiState.Error("Error") }
                }
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
    data class Success(val data: List<Movie> = emptyList()) : UiState()
    data class Error(val message: String) : UiState()

}

sealed class MovieEvent {
    data class ShowMovieDetail(val id: String) : MovieEvent()
}
