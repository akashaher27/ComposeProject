package com.example.core.di;

import android.content.Context;

import com.example.core.Navigation.NavigationRouteProvider;
import com.example.core.Navigation.Navigator;

import java.util.HashMap;

import dagger.Module;
import dagger.Provides;

@Module
public class NavigatorModule {

    @Provides
    Navigator provideNavigator(Context context, NavigationRouteProvider navigationRouteProvider) {
        return Navigator.createDefault(context, navigationRouteProvider.getRouteMap());
    }
}