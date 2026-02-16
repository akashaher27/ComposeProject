package com.example.moviefeature.domain.useCase

import android.util.Log
import com.example.moviefeature.domain.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RefreshMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke() {
        withContext(dispatcher) {
            movieRepository.refreshMovieList()
        }
    }
}

