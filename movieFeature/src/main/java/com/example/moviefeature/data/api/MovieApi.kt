package com.example.moviefeature.data.api

import com.example.moviefeature.data.model.MovieDto
import retrofit2.http.GET

interface MovieApi {

    @GET("getSection")
    suspend fun getMovieList(): List<MovieDto>
}