package com.example.core.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

interface NetworkBuilder {

    fun <T : Any> createService(apiClass: Class<T>): T

    fun addInterceptor(interceptor: Interceptor): NetworkBuilder
}

class NetworkBuilderImpl @Inject constructor() : NetworkBuilder {

    private val interceptors: MutableList<Interceptor> = mutableListOf()
    override fun <T : Any> createService(apiClass: Class<T>): T {
        return OkHttpClient
            .Builder()
            .apply {
                interceptors.forEach(this::addInterceptor)
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
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

    override fun addInterceptor(interceptor: Interceptor): NetworkBuilder {
        interceptors.add(interceptor)
        return this
    }

}

