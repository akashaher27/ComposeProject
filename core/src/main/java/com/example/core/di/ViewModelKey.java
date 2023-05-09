
package com.example.core.di;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import androidx.lifecycle.ViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import dagger.MapKey;

@Target(value = { ElementType.METHOD, ElementType.FIELD })
@Retention(RUNTIME)
@MapKey
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
