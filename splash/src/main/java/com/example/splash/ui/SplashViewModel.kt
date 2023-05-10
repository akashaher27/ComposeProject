package com.example.splash.ui

import androidx.lifecycle.ViewModel
import com.example.core.Navigation.Navigator
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    fun getStarted() {
        navigator.push("HOMESCREEN")
    }
}