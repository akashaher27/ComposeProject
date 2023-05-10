package com.example.core.Navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface Destinations {

    fun NavGraphBuilder.create(navController: NavController)
}