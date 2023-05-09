package com.example.composeproject

import android.app.Application
import com.example.composeproject.di.AppComponent

class ComposeApp() : Application() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        AppComponent.build(applicationContext)
    }
}