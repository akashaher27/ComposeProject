package com.example.ui_common.cream.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
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

@Composable
fun Heading4Text(
    text: String,
    color: Color,
    maxLine: Int
) {
    Text(
        text = text,
        color = color,
        maxLines = maxLine,
        style = AppTheme.typography.heading4
    )
}

@Composable
fun Body3Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = AppTheme.colors.themeColors.textPrimary,
    maxLine: Int = 1
) {
    AppText(
        modifier = modifier,
        text = text,
        color = color,
        style = AppTheme.typography.body3
    )
}

@Composable
fun Callout3Text(
    modifier: Modifier = Modifier,
    text: String?,
    annotatedString: AnnotatedString? = null,
    color: Color = AppTheme.colors.themeColors.textPrimary,
    maxLines: Int = Int.MAX_VALUE
) {
    AppText(
        modifier = modifier,
        text = text,
        annotatedString = annotatedString,
        color = color,
        maxLines = maxLines,
        style = AppTheme.typography.callout3
    )
}

@Composable
fun Callout2Text(
    modifier: Modifier = Modifier,
    text: String?,
    annotatedString: AnnotatedString? = null,
    color: Color = AppTheme.colors.themeColors.textPrimary,
    maxLines: Int = Int.MAX_VALUE
) {
    AppText(
        modifier = modifier,
        text = text,
        annotatedString = annotatedString,
        color = color,
        maxLines = maxLines,
        style = AppTheme.typography.callout2
    )
}

@Composable
fun Metadata1SemiBoldText(
    modifier: Modifier,
    text: String?,
    annotatedString: AnnotatedString? = null,
    color: Color
) {
    AppText(
        modifier = modifier,
        text = text,
        annotatedString = annotatedString,
        style = AppTheme.typography.metadata1SemiBold,
        color = color
    )
}

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: String?,
    annotatedString: AnnotatedString? = null,
    color: Color = AppTheme.colors.themeColors.textPrimary,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle
) {

    if (annotatedString != null) {
        Text(
            text = annotatedString,
            modifier = modifier,
            color = color,
            maxLines = maxLines,
            style = style
        )
    } else {
        Text(
            modifier = modifier,
            text = text.orEmpty(),
            color = color,
            maxLines = maxLines,
            style = style
        )
    }
}