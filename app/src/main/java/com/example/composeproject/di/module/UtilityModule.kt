package com.example.composeproject.di.module

import com.example.core.util.DateTimeProvider
import com.example.core.util.DateTimeProviderImp
import dagger.Binds
import dagger.Module

@Module
interface UtilityModule {

    @Binds
    fun provideDateTimeProvider(dateTimeProvider: DateTimeProviderImp): DateTimeProvider
}