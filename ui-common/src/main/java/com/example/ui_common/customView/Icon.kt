package com.example.ui_common.customView

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui_common.ui.common.theme.grid_x12_5
import com.example.ui_common.ui.common.theme.grid_x2

@Composable
fun InstagramIcon() {

    Canvas(
        modifier = Modifier
            .size(grid_x12_5)
            .padding(grid_x2)
    ) {
        this.drawRoundRect(
            cornerRadius = CornerRadius(60f,60f),
            brush = Brush.linearGradient(listOf(Color.Yellow, Color.Red, Color.Magenta)),
            style = Stroke(
                width = 15f,
                cap = StrokeCap.Butt
            )
        )

        this.drawCircle(
            brush = Brush.linearGradient(listOf(Color.Yellow, Color.Red, Color.Magenta)),
            center = this.center,
            radius = 45f,
            style = Stroke(
                width = 15f,
                cap = StrokeCap.Round
            )
        )

        this.drawCircle(
            brush = Brush.linearGradient(listOf(Color.Yellow, Color.Red, Color.Magenta)),
            center = Offset(size.width*.80f,size.height*.20f),
            radius = 13f
        )
    }
}

@Preview
@Composable
fun Preview(){
    InstagramIcon()
}