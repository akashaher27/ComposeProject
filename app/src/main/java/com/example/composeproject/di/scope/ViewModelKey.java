/*
 * Copyright (c) 2022 GxS. All rights reserved.
 * Last modified 6/9/22, 10:42 AM
 */

package com.example.composeproject.di.scope;

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
