package com.example.ui_common.customView

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            cornerRadius = CornerRadius(60f, 60f),
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
            center = Offset(size.width * .80f, size.height * .20f),
            radius = 13f
        )
    }
}

@Composable
fun FaceBookIcon() {
    val assetManager = LocalContext.current.assets
    val paint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = 200f
        color = Color.White.toArgb()
        typeface = Typeface.createFromAsset(assetManager, "facebookletterfaces.OTF")
    }

    Canvas(
        modifier = Modifier
            .size(grid_x12_5)
            .padding(grid_x2)
    ) {
        drawRoundRect(
            cornerRadius = CornerRadius(20f, 20f),
            color = Color(0xFF1776d1)
        )
        drawContext.canvas.nativeCanvas.drawText(
            "f",
            center.x + 25,
            center.y + 90,
            paint
        )
    }
}

@Composable
fun MessengerIcon() {
    val colors = listOf(Color(0xFF02b8f9), Color(0xFF0277fe))
    Canvas(
        modifier = Modifier
            .size(grid_x12_5)
            .padding(grid_x2)
    ) {

        drawOval(
            brush = Brush.verticalGradient(colors),
            size = Size(size.width, size.height * 0.95f)
        )
        val trianglePath = Path().let {
            it.moveTo(this.size.width * .20f, this.size.height * .77f)
            it.lineTo(this.size.width * .20f, this.size.height * 0.95f)
            it.lineTo(this.size.width * .37f, this.size.height * 0.86f)
            it.close()
            it
        }

        val electricPath = Path().let {
            it.moveTo(this.size.width * .20f, this.size.height * .60f)
            it.lineTo(this.size.width * .48f, this.size.height * .35f)
            it.lineTo(this.size.width * .55f, this.size.height * .45f)
            it.lineTo(this.size.width * .80f, this.size.height * .30f)
            it.lineTo(this.size.width * .48f, this.size.height * .58f)
            it.lineTo(this.size.width * .40f, this.size.height * .50f)
            it.close()
            it
        }

        drawPath(
            path = trianglePath,
            brush = Brush.verticalGradient(colors),
        )
        drawPath(
            path = electricPath,
            color = Color.White
        )
    }
}


@Composable
fun CircularProgressIndicator(
    indicatorValue: Int = 50,
    maxIndicatorValue: Int = 100
) {
    val startAngle = 150f
    val sweepAngle = 240f

    var currentIndicatorValue = if (indicatorValue < maxIndicatorValue) {
        (indicatorValue.toFloat() / maxIndicatorValue) * sweepAngle
    } else {
        sweepAngle
    }
    val animateIndicatorValue by animateFloatAsState(
        targetValue = currentIndicatorValue,
        animationSpec = tween(1000)
    )
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .background(Color.White)
    ) {
        val componentSize = size / 1.25f
        drawArc(
            size = componentSize,
            topLeft = Offset(
                x = (size.width - componentSize.width) / 2f,
                y = (size.height - componentSize.height) / 2f
            ),
            startAngle = startAngle,
            sweepAngle = sweepAngle,
            color = Color.Gray,
            useCenter = false,
            style = Stroke(
                width = 25f,
                cap = StrokeCap.Round
            )
        )

        drawArc(
            size = componentSize,
            topLeft = Offset(
                x = (size.width - componentSize.width) / 2f,
                y = (size.height - componentSize.height) / 2f
            ),
            startAngle = startAngle,
            sweepAngle = animateIndicatorValue,
            color = Color.Blue,
            useCenter = false,
            style = Stroke(
                width = 25f,
                cap = StrokeCap.Round
            )
        )
    }
}


@Preview
@Composable
fun Preview() {
    CircularProgressIndicator()
}