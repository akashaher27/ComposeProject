package com.example.ui_common.cream.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import com.example.ui_common.cream.foundation.AppTheme

@Composable
fun Display1Text(
    modifier: Modifier,
    text: String,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = AppTheme.typography.display1
    )

}

@Composable
fun Heading1Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = AppTheme.typography.heading1
    )
}

@Composable
fun Heading2Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = AppTheme.typography.heading2
    )
}