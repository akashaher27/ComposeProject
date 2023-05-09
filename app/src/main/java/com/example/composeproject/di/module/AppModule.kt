package com.example.composeproject.di.module;

import com.example.composeproject.navigator.AppRouteProvider;
import com.example.core.Navigation.NavigationRouteProvider;
import dagger.Binds;
import dagger.Module;

@Module
interface AppModule {

    @Binds
    fun provideAppRouteProvider(appRouteProvider: AppRouteProvider): NavigationRouteProvider
}