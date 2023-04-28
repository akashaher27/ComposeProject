package com.example.composeproject.di;

import com.example.core.di.MainInjector;

import dagger.Component;

@Component(modules = {ViewModelModule.class})
public interface AppComponent extends MainInjector {

    @Component.Factory
    interface Factory {
        AppComponent build();
    }

    static AppComponent build() {
        AppComponent appComponent = DaggerAppComponent
                .factory()
                .build();
        MainInjector.setMainInjector(appComponent);
        return appComponent;
    }
}