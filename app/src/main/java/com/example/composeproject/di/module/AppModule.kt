package com.example.composeproject.di.module;

import com.example.composeproject.navigator.AppRouteProvider;
import com.example.core.Navigation.NavigationRouteProvider;
import com.example.core.network.NetworkBuilder
import com.example.core.network.NetworkBuilderImpl
import dagger.Binds;
import dagger.Module;

@Module
interface AppModule {

    @Binds
    fun provideAppRouteProvider(appRouteProvider: AppRouteProvider): NavigationRouteProvider

    @Binds
    fun provideNetworkBuilder(networkBuilderImpl: NetworkBuilderImpl):NetworkBuilder
}