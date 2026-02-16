package com.example.moviefeature.data.di;

import com.example.core.database.LocalDatabase;
import com.example.core.database.MovieDao;
import com.example.core.network.NetworkBuilder;
import com.example.moviefeature.data.api.MovieApi;
import com.example.moviefeature.data.repo.MovieRepositoryImp;
import com.example.moviefeature.domain.MovieRepository;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public interface MovieModule {
    @Binds
    MovieRepository provideMovieRepository(MovieRepositoryImp movieRepositoryImp);

    @Provides
    static MovieApi provideHomeApi(NetworkBuilder networkBuilder) {
        return networkBuilder.createService(MovieApi.class);
    }

    @Provides
    static MovieDao provideMovieDao(LocalDatabase localDatabase) {
        return localDatabase.movieDao();
    }
}
