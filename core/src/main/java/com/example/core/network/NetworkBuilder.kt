package com.example.core.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject

interface NetworkBuilder {

    fun <T : Any> createService(apiClass: Class<T>): T
}

class NetworkBuilderImpl @Inject constructor() : NetworkBuilder {

    override fun <T : Any> createService(apiClass: Class<T>): T {
        return OkHttpClient
            .Builder()
            .build()
            .let { okHttpClient ->
                Retrofit
                    .Builder()
                    .baseUrl("https://www.youtube.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
                    .create(apiClass)
            }
    }

}

