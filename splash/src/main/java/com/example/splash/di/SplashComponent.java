package com.example.splash.di;

import android.content.Context;

import com.example.core.di.MainInjector;
import com.example.splash.SplashActivity;

import org.jetbrains.annotations.NotNull;

import dagger.BindsInstance;
import dagger.Component;

@Component(
        dependencies = {MainInjector.class}
)
public interface SplashComponent {

    @Component.Factory
    interface Factory {
        SplashComponent build(MainInjector mainInjector);
    }

    void inject(SplashActivity activity);

    static void initAndInject(@NotNull SplashActivity activity) {
        DaggerSplashComponent.factory()
                .build(MainInjector.getInstance())
                .inject(activity);
    }

}