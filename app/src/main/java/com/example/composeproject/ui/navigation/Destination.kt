package com.example.composeproject.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface Destination {

    fun NavGraphBuilder.create(navController: NavController)
}