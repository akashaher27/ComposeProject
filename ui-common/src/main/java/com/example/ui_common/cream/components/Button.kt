package com.example.ui_common.cream.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_common.cream.foundation.AppTheme
import com.example.ui_common.ui.common.theme.grid_x0
import com.example.ui_common.ui.common.theme.grid_x2
import com.example.ui_common.ui.common.theme.grid_x4

@Composable
fun SmallPrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enable: Boolean = true,
    onClick: () -> Unit
) {
    AppButton(
        modifier = modifier,
        text = text,
        textStyle = AppTheme.typography.callout3,
        enable = enable,
        shape = AppTheme.shapes.small,
        backgroundColor = AppTheme.colors.themeColors.brandPrimary,
        contentColor = AppTheme.colors.themeColors.textPrimary,
        disabledBackgroundColor = AppTheme.colors.themeColors.backgroundDisabled,
        disabledContentColor = AppTheme.colors.themeColors.textDisabled,
    ) {
        onClick()
    }
}

@Composable
fun LargePrimaryButton() {
}

@Composable
fun SmallSecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enable: Boolean = true,
    onClick: () -> Unit
) {
    AppButton(
        modifier = modifier
            .border(
                width = 1.dp,
                color = if (enable) AppTheme.colors.themeColors.textSecondary else AppTheme.colors.themeColors.textDisabled,
                shape = CircleShape
            )
            .requiredHeight(grid_x4),
        text = text,
        textStyle = AppTheme.typography.callout3,
        enable = enable,
        shape = AppTheme.shapes.small,
        backgroundColor = Color.Transparent,
        contentColor = AppTheme.colors.themeColors.textSecondary,
        disabledBackgroundColor = Color.Transparent,
        disabledContentColor = AppTheme.colors.themeColors.textDisabled,
    ) {
        onClick()
    }
}

@Composable
fun LargeSecondaryButton() {
}

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle,
    enable: Boolean = true,
    shape: Shape,
    backgroundColor: Color,
    contentColor: Color,
    disabledBackgroundColor: Color,
    disabledContentColor: Color,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        enabled = enable,
        elevation = null,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            disabledBackgroundColor = disabledBackgroundColor,
            disabledContentColor = disabledContentColor,
        ),
        contentPadding = PaddingValues(vertical = grid_x0, horizontal = grid_x2),
        onClick = { onClick() }
    ) {
        AppText(
            text = text,
            color = if (enable) contentColor else disabledContentColor,
            style = textStyle,
        )
    }
}


@Composable
fun AppIconButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    IconButton(
        modifier = modifier,
        enabled = enabled,
        onClick = { onClick() }
    ) {
        content()
    }
}

@Composable
fun LargeIconButton() {
}

@Composable
fun MediumIconButton() {
}

@Composable
fun SmallIconButton() {

}


@Composable
fun HorizontalButtonGroup() {
}


@Composable
fun VerticalButtonGroup() {
}


@Preview
@Composable
fun Preview() {
    SmallSecondaryButton(
        text = "CTA"
    ) {

    }
}