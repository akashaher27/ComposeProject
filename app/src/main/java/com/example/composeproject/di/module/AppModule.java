package com.example.composeproject.di.module;

import android.content.Context;

import com.example.composeproject.navigator.AppRouteProvider;
import com.example.core.Navigation.NavigationRouteProvider;
import com.example.core.database.LocalDatabase;
import com.example.core.network.NetworkBuilder;
import com.example.core.network.NetworkBuilderImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Module
public interface AppModule {
    @Binds
    NavigationRouteProvider provideAppRouteProvider(AppRouteProvider appRouteProvider);

    @Binds
    NetworkBuilder provideNetworkBuilder(NetworkBuilderImpl networkBuilderImpl);

    @Provides
    static CoroutineDispatcher provideCoroutineDispatcher() {
        return Dispatchers.getIO();
    }

    @Singleton
    @Provides
    static LocalDatabase provideLocalDataBase(Context context){
        return LocalDatabase.Companion.create(context);
    }

}
