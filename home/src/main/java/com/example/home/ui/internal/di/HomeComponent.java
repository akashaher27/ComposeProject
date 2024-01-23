package com.example.home.ui.internal.di;


import com.example.core.di.MainInjector;
import com.example.home.ui.internal.dashboard.DashBoardViewModel;
import com.example.home.ui.internal.dashboard.PluginViewModel;
import com.example.home.ui.internal.dashboard.plugin.WelcomeBannerViewModel;

import dagger.Component;


@Component(
        modules = {
                HomeModule.class
        },
        dependencies= {
        MainInjector.class
}
)
public interface HomeComponent {

    @Component.Factory
    interface Factory {
        HomeComponent build(
                MainInjector injector
        );
    }

    static HomeComponent build() {
        return DaggerHomeComponent
                .factory()
                .build(MainInjector.getInstance());
    }

    DashBoardViewModel dashBoardViewModel();

    WelcomeBannerViewModel welcomeBannerViewModel();

    PluginViewModel pluginViewModel();
}
