package com.example.home.di;


import com.example.home.ui.internal.dashboard.DashBoardViewModel;

import dagger.Component;


@Component
public interface HomeComponent {

    static HomeComponent build() {
        HomeComponent homeComponent = DaggerHomeComponent.create();
        return homeComponent;
    }

    DashBoardViewModel dashBoardViewModel();
}
