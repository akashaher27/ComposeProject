package com.example.moviefeature.domain

import com.example.moviefeature.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovieList(): Flow<List<Movie>>

    suspend fun refreshMovieList()
}

