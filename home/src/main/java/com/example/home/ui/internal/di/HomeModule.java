package com.example.home.ui.internal.di;

import com.example.core.network.NetworkBuilder;
import com.example.home.ui.internal.data.api.HomeApi;
import com.example.home.ui.internal.data.repo.HomeRepoImp;
import com.example.home.ui.internal.domain.repo.HomeRepo;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public interface HomeModule {

    @Provides
    static HomeApi provideHomeApi(NetworkBuilder networkBuilder) {
        return networkBuilder.createService(HomeApi.class);
    }

    @Binds
    HomeRepo provideHomeRepo(HomeRepoImp homeRepoImp);

}
