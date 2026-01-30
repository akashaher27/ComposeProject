package com.example.moviefeature.data.di;


import com.example.core.di.MainInjector;
import com.example.moviefeature.presenter.MovieViewModel;

import dagger.Component;

@Component(
        modules = {
                MovieModule.class
        },
        dependencies = {
                MainInjector.class
        }
)
public interface MovieComponent {

    @Component.Factory
    interface Factory {
        MovieComponent build(MainInjector mainInjector);
    }

    static MovieComponent build() {
        return DaggerMovieComponent
                .factory()
                .build(MainInjector.getInstance());
    }

    MovieViewModel movieViewModel();
}
