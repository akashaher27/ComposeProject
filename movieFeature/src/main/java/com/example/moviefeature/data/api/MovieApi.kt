package com.example.moviefeature.data.api

import com.example.moviefeature.data.model.MovieDto

interface MovieApi {

    suspend fun getMovieList(): List<MovieDto>
}