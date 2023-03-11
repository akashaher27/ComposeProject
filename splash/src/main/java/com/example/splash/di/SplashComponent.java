package com.example.splash.di;

import android.content.Context;

import com.example.splash.SplashActivity;

import org.jetbrains.annotations.NotNull;

import dagger.BindsInstance;
import dagger.Component;

@Component(
        modules = {
                SplashVmModule.class
        }
)
public interface SplashComponent {

    @Component.Factory
    interface Factory {
        SplashComponent build();
    }

    void inject(SplashActivity activity);

    static void initAndInject(@NotNull SplashActivity activity) {
        DaggerSplashComponent.factory()
                .build()
                .inject(activity);
    }

}