package com.example.ui_common.cream.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun AppAsyncImage(
    model: Any?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    contentDescription: String? = null
) {
    AsyncImage(
        model = model,
        modifier = modifier,
        contentScale = contentScale,
        contentDescription = contentDescription
    )
}