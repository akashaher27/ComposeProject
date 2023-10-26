package com.example.home.ui.internal.dashboard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.home.R
import com.example.home.ui.internal.dashboard.plugin.Plugin
import com.example.ui_common.cream.components.AppScaffold
import com.example.ui_common.cream.components.Heading2Text
import com.example.ui_common.cream.foundation.AppTheme
import com.example.ui_common.ui.common.theme.grid_x16
import com.example.ui_common.ui.common.theme.grid_x2
import com.example.ui_common.ui.common.theme.grid_x3
import com.example.ui_common.ui.common.theme.grid_x4
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
internal fun DashBoardScreen(
    viewModel: DashBoardViewModel
) {
    val viewState by viewModel.dashboardViewState.collectAsState()
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = false),
        onRefresh = {},
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeScreenBackGround()
        AppScaffold(
            backgroundColor = Color.Transparent,
            topBar = {
                HomeScreenTopBar()
            }
        ) {
            if (viewState.isLoading) {
                HomeScreenLoading()
            } else {
                HomeScreenPlugin(viewState.plugin)
            }

        }
    }


}

@Composable
private fun HomeScreenBackGround() {
    Image(
        painter = painterResource(id = R.drawable.ic_home_top_gradient),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
private fun HomeScreenTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = grid_x3, end = grid_x3, top = grid_x3, bottom = grid_x2),
    ) {
        Heading2Text(
            text = stringResource(id = R.string.bank),
            color = AppTheme.colors.themeColors.textPrimary
        )
    }
}

@Composable
private fun HomeScreenLoading() {
    AnimatedVisibility(
        visible = true,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(grid_x2),
            verticalArrangement = Arrangement.spacedBy(grid_x3)
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(grid_x16)
                    .requiredHeight(grid_x4)
                    .clip(shape = AppTheme.shapes.small)
                    .background(color = AppTheme.colors.themeColors.backgroundTertiary)
                    .placeholder(
                        visible = true,
                        highlight = PlaceholderHighlight.shimmer()
                    )
            )
            repeat(3) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(grid_x16)
                        .clip(shape = AppTheme.shapes.small)
                        .background(color = AppTheme.colors.themeColors.backgroundTertiary)
                        .placeholder(
                            visible = true,
                            highlight = PlaceholderHighlight.shimmer()
                        )
                )
            }
        }
    }
}

@Composable
private fun HomeScreenPlugin(plugin: List<Plugin>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = grid_x2),
        verticalArrangement = Arrangement.spacedBy(grid_x3)
    ) {
        items(
            items = plugin
        ) {
            it.ComposableContent()
        }
    }
}

