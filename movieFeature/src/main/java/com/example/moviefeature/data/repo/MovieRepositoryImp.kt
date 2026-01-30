package com.example.moviefeature.data.repo

import com.example.moviefeature.data.api.MovieApi
import com.example.moviefeature.data.model.MovieDto
import com.example.moviefeature.domain.MovieRepository
import com.example.moviefeature.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val movieApi: MovieApi
) : MovieRepository {

    override suspend fun getMovieList(): List<Movie> {
        //movieApi.getMovieList()
        return fetchMovieList().map { it.toMovie() }
    }

    //Fake api call
    private suspend fun fetchMovieList(): List<MovieDto> {
        delay(1000)
        return listOf(
            MovieDto("name1", "genre1"),
            MovieDto("name2", "genre2"),
            MovieDto("name3", "genre3"),
            MovieDto("name4", "genre4"),
            MovieDto("name5", "genre5"),
            MovieDto("name6", "genre6"),
            MovieDto("name7", "genre7"),
            MovieDto("name8", "genre8"),
            MovieDto("name9", "genre9")
        )
    }
}

fun MovieDto.toMovie() = Movie(
    name = name ?: "",
    genre = genre ?: ""
)