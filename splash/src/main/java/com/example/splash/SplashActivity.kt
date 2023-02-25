package com.example.splash

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.ui_common.ui.extension.toFullScreen

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.toFullScreen()
        setContent {
            splashView()
        }
    }

    @Composable
    private fun splashView() {

        Image(
            painter = painterResource(id = com.example.ui_common.R.drawable.ic_compose),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

    }
}