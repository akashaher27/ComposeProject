package com.example.core.di

import com.example.core.Navigation.NavigationRouteProvider
import com.example.core.network.NetworkBuilder
import com.example.core.util.DateTimeProvider
import kotlinx.coroutines.CoroutineDispatcher
import java.lang.IllegalStateException

interface MainInjector {

    fun navRoutesProvider(): NavigationRouteProvider

    fun dateTimeProvider(): DateTimeProvider

    fun networkBuilderProvider(): NetworkBuilder

    fun coroutineDispatcherProvider():CoroutineDispatcher

    companion object {
        private var _instance: MainInjector? = null

        @JvmStatic
        val instance: MainInjector
            get() = _instance
                ?: throw IllegalStateException("MainInjector.instance not initialized!")

        @JvmStatic
        fun setMainInjector(mainInjector: MainInjector) {
            if (_instance == null) {
                _instance = mainInjector
            }
        }
    }
}
