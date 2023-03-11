package com.example.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor() : ViewModel() {

    fun getStarted() {
        Log.d("test", "getStarted: ")
    }
}