package com.example.home.ui.internal.dashboard.plugin

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui_common.cream.components.Body3Text
import com.example.ui_common.cream.components.Callout3Text
import com.example.ui_common.ui.common.theme.grid_x0_5
import com.example.ui_common.ui.common.theme.grid_x1

internal class WelcomeBannerPlugin() : Plugin {

    @Composable
    override fun ComposableContent() {
        WelcomeBanner()
    }

    @Composable
    private fun WelcomeBanner() {
        Row {
            Body3Text(
                modifier = Modifier
                    .padding(start = grid_x1),
                text = "Hello"
            )

            Callout3Text(
                modifier = Modifier
                    .padding(start = grid_x0_5),
                text = "Akash"
            )
        }
    }


    @Preview
    @Composable
    private fun Preview() {
        WelcomeBanner()
    }

}