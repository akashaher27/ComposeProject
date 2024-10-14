package com.example.home.ui.internal.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.home.R
import com.example.home.ui.internal.ui.dashboard.plugin.Plugin
import com.example.ui_common.cream.components.AppScaffold
import com.example.ui_common.cream.foundation.AppTheme
import com.example.ui_common.ui.common.theme.grid_x16
import com.example.ui_common.ui.common.theme.grid_x2
import com.example.ui_common.ui.common.theme.grid_x3
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.material.placeholder

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun DashBoardScreen(
    viewModel: DashBoardViewModel
) {
    val viewState by viewModel.dashboardViewState.collectAsState()

    val pullToRefreshState = rememberPullRefreshState(
        refreshing = false,
        onRefresh = {
            TODO("@akash implement refresh call")
        }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullToRefreshState)
    ) {
        HomeScreenBackGround()
        AppScaffold(
            backgroundColor = Color.Transparent,
        ) {
            when(viewState){
                ViewState.Loading -> ShowLoadingState()
                is ViewState.Success -> TODO()
                ViewState.Error -> TODO()

            }
        }
    }
}

@Composable
private fun ShowLoadingState() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(grid_x2),
        verticalArrangement = Arrangement.spacedBy(grid_x3)
    ) {

        repeat(10){
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
