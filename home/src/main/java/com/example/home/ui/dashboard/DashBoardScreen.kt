package com.example.home.ui.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ui_common.cream.components.AppScaffold

@Composable
fun DashBoardScreen() {
    AppScaffold(
        content = {
            Box(
                modifier = Modifier
                    .padding(it)
            )
            Text(
                text = "Akash"
            )
        }
    )

}