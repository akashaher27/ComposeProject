package com.example.home.ui.internal.dashboard.plugin

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui_common.cream.components.Body3Text
import com.example.ui_common.cream.components.Callout3Text
import com.example.ui_common.ui.common.theme.grid_x0_5
import com.example.ui_common.ui.common.theme.grid_x1

internal class WelcomeBannerPlugin(private val viewModel: WelcomeBannerViewModel) : Plugin {

    @Composable
    override fun ComposableContent() {
        val viewState by viewModel.welcomeBannerViewState.collectAsState()
        WelcomeBanner(
            welcomeMessage = stringResource(id = viewState.welcomeMessage),
            userName = viewState.userName
        )
    }
}

@Composable
private fun WelcomeBanner(
    welcomeMessage: String,
    userName: String
) {
    Row {
        Body3Text(
            modifier = Modifier
                .padding(start = grid_x1),
            text = welcomeMessage
        )

        Callout3Text(
            modifier = Modifier
                .padding(start = grid_x0_5),
            text = userName
        )
    }
}

@Preview
@Composable
private fun Preview() {
    WelcomeBanner(
        welcomeMessage = "Good Morning",
        userName = "Akash"
    )
}

