package com.example.moviefeature.data.repo

import android.util.Log
import com.example.core.database.MovieDao
import com.example.core.database.MovieRoomModel
import com.example.moviefeature.data.api.MovieApi
import com.example.moviefeature.data.model.MovieDto
import com.example.moviefeature.domain.MovieRepository
import com.example.moviefeature.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

//try multiple network request and cache data

class MovieRepositoryImp @Inject constructor(
    private val movieDao: MovieDao,
    private val movieApi: MovieApi
) : MovieRepository {

    override fun getMovieList(): Flow<List<Movie>> {
        return movieDao.getMovie()
            .map { movieRoomModelList -> movieRoomModelList.map { movie -> movie.toMovie() } }
    }

    override suspend fun refreshMovieList() {
        fakeNetworkCall()
            .map { it.toMovieRoomModel() }
            .also { movieDao.insertMovie(it) }
    }

    private suspend fun fakeNetworkCall(): List<MovieDto> {
        delay(5000)
        return listOf(
            MovieDto(
                name = "Avengers",
                genre = "Action1"
            ),
            MovieDto(
                name = "Avengers",
                genre = "Action2"
            ),
            MovieDto(
                name = "Avengers",
                genre = "Action3"
            ),
            MovieDto(
                name = "Avengers",
                genre = "Action4"
            ),
            MovieDto(
                name = "Avengers",
                genre = "Action5"
            ),
            MovieDto(
                name = "Avengers",
                genre = "Action6"
            ),
        )
    }
}


fun MovieDto.toMovieRoomModel() = MovieRoomModel(
    name = name ?: "",
    genre = genre ?: ""
)

fun MovieRoomModel.toMovie(): Movie {
    return Movie(
        name = this.name ?: "",
        genre = this.genre ?: ""
    )
}



