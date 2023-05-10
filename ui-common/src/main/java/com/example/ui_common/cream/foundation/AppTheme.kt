package com.example.ui_common.cream.foundation

import androidx.compose.material.LocalElevationOverlay
import androidx.compose.material.MaterialTheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


object AppTheme {
    val colors: AppColors = AppColors
    val shapes: AppShapes = AppShapes
    val typography: AppTypography = AppTypography()
}

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = AppTheme.colors.materialColors,
        shapes = AppTheme.shapes.materialShapes,
        typography = AppTheme.typography.materialTypography,
        content = content
    )
}