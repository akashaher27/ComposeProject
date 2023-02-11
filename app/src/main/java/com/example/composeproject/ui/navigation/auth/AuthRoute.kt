package com.example.composeproject.ui.navigation.auth

object AuthRoute {
    const val ROOT = "auth"
    const val LOGIN_SCREEN = "$ROOT/login"

    fun openLoginScreen(): String = LOGIN_SCREEN
}