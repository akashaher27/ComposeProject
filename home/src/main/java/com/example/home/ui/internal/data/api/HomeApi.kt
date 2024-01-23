package com.example.home.ui.internal.data.api

import com.example.home.ui.internal.data.model.Section
import retrofit2.http.GET

internal interface HomeApi {

    @GET("getSection")
    suspend fun getSection(): List<Section>
}