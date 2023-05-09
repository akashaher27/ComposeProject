package com.example.core.di

import com.example.core.Navigation.NavigationRouteProvider
import java.lang.IllegalStateException

interface MainInjector {

    fun navRoutesProvider(): NavigationRouteProvider

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
