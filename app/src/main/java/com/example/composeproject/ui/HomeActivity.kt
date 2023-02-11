package com.example.composeproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.composeproject.ui.navigation.Destination
import com.example.composeproject.ui.navigation.HomeRoot
import com.example.composeproject.ui.navigation.auth.AuthDestination
import com.example.composeproject.ui.navigation.home.HomeDestination


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            HomeRoot(navController, createDestination())
        }
    }

    private fun createDestination(): Set<Destination> = setOf(
        HomeDestination(),
        AuthDestination()
    )

}

