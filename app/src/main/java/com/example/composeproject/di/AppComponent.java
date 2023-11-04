package com.example.composeproject.di;

import android.content.Context;

import com.example.composeproject.di.module.AppModule;
import com.example.composeproject.di.module.UtilityModule;
import com.example.core.di.MainInjector;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {
        AppModule.class,
        UtilityModule.class
})
public interface AppComponent extends MainInjector {

    @Component.Factory
    interface Factory {
        AppComponent build(@BindsInstance Context context);
    }

    static AppComponent build(Context context) {
        AppComponent appComponent = DaggerAppComponent
                .factory()
                .build(context);
        MainInjector.setMainInjector(appComponent);
        return appComponent;
    }
}