package com.example.ui_common.cream.foundation

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.ui_common.R
import com.example.ui_common.ui.common.theme.grid_x2

object AppIcon {

    @Composable
    fun Cross(
        size: Dp,
        tintColor: Color? = null
    ) = AppIcon(
        iconRes = R.drawable.close_24px,
        size = size,
        tintColor = tintColor
    )

    @Composable
    fun AppIcon(
        iconRes: Int,
        size: Dp,
        tintColor: Color?,
    ) {
        Icon(
            modifier = Modifier
                .size(size),
            painter = painterResource(id = iconRes),
            tint = tintColor ?: Color.Unspecified,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun Preview() {
    AppIcon.Cross(
        size = grid_x2
    )
}