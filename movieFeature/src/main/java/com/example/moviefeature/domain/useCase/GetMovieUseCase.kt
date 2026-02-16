package com.example.moviefeature.domain.useCase

import com.example.core.util.resultOf
import com.example.moviefeature.domain.MovieRepository
import com.example.moviefeature.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<List<Movie>> {
        return movieRepository.getMovieList()
    }
}


//withContext - In Case of heavy work like processing any data should be done on background thread.