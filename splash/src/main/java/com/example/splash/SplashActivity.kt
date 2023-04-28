package com.example.splash

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModelProvider

import com.example.splash.di.SplashComponent
import com.example.ui_common.ui.extension.toFullScreen
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.toFullScreen()
        SplashComponent.initAndInject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[SplashViewModel::class.java]
        setContent {
            viewModel.getStarted()
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