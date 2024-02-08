package com.example.home.ui.internal.ui.dashboard.plugin.ForYouToday

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.home.ui.internal.ui.dashboard.PluginViewModel
import com.example.home.ui.internal.ui.dashboard.plugin.Plugin
import com.example.ui_common.cream.components.Metadata1SemiBoldText
import com.example.ui_common.cream.components.cards.ComfortableCard
import com.example.ui_common.cream.foundation.AppTheme
import com.example.ui_common.ui.common.theme.grid_x1

internal class ForYouTodayPlugin(pluginViewModel: PluginViewModel) : Plugin {

    @Composable
    override fun ComposableContent() {
        ForYouTodaySection()
    }
}

@Composable
private fun ForYouTodaySection() {

    Column(
        verticalArrangement = Arrangement.spacedBy(grid_x1)
    ) {
        Metadata1SemiBoldText(
            modifier = Modifier,
            text = "FOR YOU TODAY",
            color = AppTheme.colors.themeColors.textTertiary
        )
        ForYouTodayCard()
    }
}

@Composable
private fun ForYouTodayCard() {
    ComfortableCard(
        title = "Title",
        subtitle = "Subtitle",
        imageUrl = "",
        buttonText = " CTA",
        onCtaClick = { /*TODO*/ })
}

@Preview
@Composable
private fun Preview() {
    ForYouTodaySection()
}



