package com.example.composeproject.ui.navigation.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.composeproject.ui.auth.LoginScreen
import com.example.composeproject.ui.navigation.Destination

class AuthDestination() : Destination {

    override fun NavGraphBuilder.create(navController: NavController) {
        navigation(
            startDestination = AuthRoute.openLoginScreen(),
            route = AuthRoute.ROOT
        ) {
            loginScreen()
        }
    }

    private fun NavGraphBuilder.loginScreen() {
        composable(
            route = AuthRoute.LOGIN_SCREEN
        ) {
            LoginScreen()
        }
    }
}