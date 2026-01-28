package com.example.moviefeature.domain.useCase

import com.example.core.util.resultOf
import com.example.moviefeature.domain.MovieRepository
import com.example.moviefeature.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetMovieUseCase(
    private val movieRepository: MovieRepository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(): Result<List<Movie>> {
        return resultOf {
            withContext(dispatcher) {
                movieRepository.getMovieList()
            }
        }
    }
}


//withContext - In Case of heavy work like processing any data should be done on background thread.