package com.example.home.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.example.home.ui.internal.di.HomeComponent
import com.example.ui_common.cream.components.AppBottomSheetLayout
import com.example.ui_common.cream.foundation.AppTheme
import com.example.ui_common.ui.extension.toFullScreen
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator

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
            val bottomSheetNavigator = rememberBottomSheetNavigator()
            val homeComponent: HomeComponent by lazy {
                HomeComponent.build()
            }
            AppTheme {
                AppBottomSheetLayout(
                    bottomSheetNavigator = bottomSheetNavigator,
                    content = {
                        HomeRoot(
                            navController = navController,
                            destinations = createDestinations(homeComponent)
                        )
                    }
                )
            }
        }
    }

    private fun createDestinations(homeComponent: HomeComponent) = setOf(HomeDestinations(homeComponent))
}

