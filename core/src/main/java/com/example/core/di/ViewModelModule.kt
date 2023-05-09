package com.example.core.di

import androidx.lifecycle.ViewModelProvider
import com.example.core.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun bind(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}