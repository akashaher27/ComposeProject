package com.example.core.Navigation

import android.content.Context
import android.util.Log
import javax.inject.Inject

interface Navigator {

    fun push(route: String, arg: Map<String, String> = emptyMap())

    fun push(route: Route, args: Map<String, String> = emptyMap())

    companion object {
        @JvmStatic
        fun createDefault(context: Context, routes: Map<String, Route>): Navigator =
            createAndroidNavigator(context, routes)
    }
}

const val TAG = "AndroidNavigator"

class AndroidNavigator @Inject constructor(
    private val context: Context,
    private val routeMap: Map<String, Route>
) : Navigator {

    override fun push(route: String, arg: Map<String, String>) {
        push(getRouteByName(route))
    }

    override fun push(route: Route, args: Map<String, String>) {
        when (route) {
            is ContextRoute -> executeContextRoute(route)
            else -> warnUnKnowRoute(route)
        }
    }

    private fun executeContextRoute(route: ContextRoute) {
        route.routeBuilder(context)
    }

    private fun getRouteByName(route: String): Route {
        return routeMap[route] ?: UnknownRoute
    }

    private fun warnUnKnowRoute(route: Route) {
        Log.d(TAG, "warnUnKnowRoute:$route ")
    }
}

internal fun createAndroidNavigator(context: Context, routes: Map<String, Route>) =
    AndroidNavigator(context, routes)





