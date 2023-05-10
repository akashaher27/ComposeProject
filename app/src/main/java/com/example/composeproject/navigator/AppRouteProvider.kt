package com.example.composeproject.navigator


import com.example.core.Navigation.ContextRoute
import com.example.core.Navigation.NavigationRouteProvider
import com.example.home.ui.HomeActivity
import javax.inject.Inject


class AppRouteProvider @Inject constructor() : NavigationRouteProvider {

    private val homeScreenRoute = ContextRoute { context ->
        context.startActivity(
            HomeActivity.intent(context)
        )
    }

    override val routeMap = mapOf(
        Path.HOMESCREEN.name to homeScreenRoute
    )

    enum class Path {
        HOMESCREEN
    }

}