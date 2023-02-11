package com.example.composeproject.ui.navigation.home

object HomeRoute {
    const val ROOT = "home"
    const val DASHBOARD = "$ROOT/dashboard"



    fun openDashBoard(): String = DASHBOARD
}