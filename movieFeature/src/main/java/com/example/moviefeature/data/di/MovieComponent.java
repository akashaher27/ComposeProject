package com.example.moviefeature.data.di;


import com.example.moviefeature.presenter.MovieViewModel;

import dagger.Component;

@Component(
        modules = {
                MovieModule.class
        }
)
public interface MovieComponent {

    @Component.Factory
    interface Factory {
        MovieComponent build();
    }

    static MovieComponent build() {
        return DaggerMovieComponent
                .factory()
                .build();
    }

    MovieViewModel movieViewModel();
}
