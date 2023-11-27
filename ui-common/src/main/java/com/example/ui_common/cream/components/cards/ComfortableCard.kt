package com.example.ui_common.cream.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.request.ImageRequest
import com.example.ui_common.R
import com.example.ui_common.cream.components.AppAsyncImage
import com.example.ui_common.cream.components.Body3Text
import com.example.ui_common.cream.components.Callout2Text
import com.example.ui_common.cream.components.SmallSecondaryButton
import com.example.ui_common.cream.foundation.AppIcon
import com.example.ui_common.cream.foundation.AppTheme
import com.example.ui_common.ui.common.theme.grid_x0_5
import com.example.ui_common.ui.common.theme.grid_x1
import com.example.ui_common.ui.common.theme.grid_x15
import com.example.ui_common.ui.common.theme.grid_x2
import com.example.ui_common.ui.common.theme.grid_x3


@Composable
fun ComfortableCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    imageUrl: String,
    buttonText: String,
    backgroundColor: Color = AppTheme.colors.themeColors.backgroundPrimary,
    onCtaClick: () -> Unit,
    onCloseClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        shape = AppTheme.shapes.large,
        backgroundColor = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .padding(grid_x2),
            horizontalArrangement = Arrangement.spacedBy(grid_x2)
        ) {
            AppAsyncImage(
                modifier = Modifier
                    .size(grid_x15),
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(imageUrl)
                    .placeholder(R.drawable.ic_compose)
                    .build(),
            )
            Column {
                Callout2Text(
                    text = title,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.height(grid_x0_5))
                Body3Text(
                    text = subtitle,
                    color = Color.Blue
                )
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(grid_x1)
                )
                SmallSecondaryButton(
                    text = buttonText
                ) {
                    onCtaClick()
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            if (onCloseClick != null) {
                IconButton(
                    modifier = Modifier
                        .size(grid_x3),
                    onClick = {
                        onCloseClick()
                    }
                ) {
                    AppIcon.Cross(size = grid_x3)
                }

            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ComfortableCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        title = "Title",
        subtitle = "Subtitle",
        imageUrl = "",
        buttonText = "CTA",
        onCtaClick = {},
        onCloseClick = {}
    )
}