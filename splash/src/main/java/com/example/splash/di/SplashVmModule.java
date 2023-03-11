package com.example.splash.di;

import androidx.lifecycle.ViewModel;

import com.example.splash.SplashViewModel;

import dagger.Binds;
import dagger.Module;

@Module
public interface SplashVmModule {

    @Binds
    ViewModel bind(SplashViewModel vm);
}
