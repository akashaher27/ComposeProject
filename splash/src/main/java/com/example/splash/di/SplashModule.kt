package com.example.splash.di

import androidx.lifecycle.ViewModel
import com.example.core.di.ViewModelKey
import com.example.core.di.ViewModelModule
import com.example.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
interface SplashModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bind(splashViewModel: SplashViewModel): ViewModel
}