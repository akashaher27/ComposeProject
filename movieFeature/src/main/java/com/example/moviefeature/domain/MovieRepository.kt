package com.example.moviefeature.domain

import com.example.moviefeature.domain.model.Movie

interface MovieRepository {

    suspend fun getMovieList(): List<Movie>
}

