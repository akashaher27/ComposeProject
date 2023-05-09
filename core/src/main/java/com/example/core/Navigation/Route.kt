package com.example.core.Navigation

import android.content.Context

sealed class Route

data class ContextRoute(val routeBuilder: (context: Context) -> Unit) : Route()
object UnknownRoute : Route()