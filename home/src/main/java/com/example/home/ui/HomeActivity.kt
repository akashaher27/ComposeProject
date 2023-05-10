package com.example.home.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.core.Navigation.Destinations
import com.example.ui_common.cream.foundation.AppTheme
import com.example.ui_common.ui.extension.toFullScreen

const val TAG = "HomeActivity"

class HomeActivity : AppCompatActivity() {

    companion object {
        fun intent(context: Context) = Intent(
            context,
            HomeActivity::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toFullScreen()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = HomeRoutes.ROOT,
            ) {
                val destinations = createDestinations()
                destinations.forEach { destination ->
                    with(destination) {
                        create(navController)
                    }
                }
            }
        }
    }

    private fun createDestinations() = setOf(
        HomeDestinations()
    )
}
