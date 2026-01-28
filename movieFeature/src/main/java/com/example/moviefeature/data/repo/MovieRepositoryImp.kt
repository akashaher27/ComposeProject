package com.example.moviefeature.data.repo

import com.example.moviefeature.data.api.MovieApi
import com.example.moviefeature.data.model.MovieDto
import com.example.moviefeature.domain.MovieRepository
import com.example.moviefeature.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class MovieRepositoryImp(
    private val movieApi: MovieApi
) : MovieRepository {

    override suspend fun getMovieList(): List<Movie> {
        return movieApi.getMovieList().map { it.toMovie() }
    }
}

fun MovieDto.toMovie() = Movie(
    name = name ?: "",
    genre = genre ?: ""
)