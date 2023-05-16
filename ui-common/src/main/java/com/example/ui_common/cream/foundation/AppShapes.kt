package com.example.ui_common.cream.foundation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp
import com.example.ui_common.ui.common.theme.grid_x1
import com.example.ui_common.ui.common.theme.grid_x1_5
import com.example.ui_common.ui.common.theme.grid_x3

object AppShapes {

    val xsmall = RoundedCornerShape(grid_x1)
    val small = RoundedCornerShape(grid_x1_5)
    val large = RoundedCornerShape(grid_x3)
    val maxium = RoundedCornerShape(percent = 100)

    val materialShapes = Shapes(
        small = xsmall,
        medium = small,
        large = large
    )
}