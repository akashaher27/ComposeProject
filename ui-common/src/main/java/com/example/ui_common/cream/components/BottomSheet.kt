package com.example.ui_common.cream.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.ui_common.cream.foundation.AppTheme
import com.example.ui_common.ui.common.theme.grid_x3
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ModalBottomSheetLayout


@Composable
fun AppBottomSheetLayout(
    bottomSheetNavigator: BottomSheetNavigator,
    scrimColor: Color = AppTheme.colors.themeColors.backgroundScrim,
    content: @Composable () -> Unit
) {
    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetBackgroundColor = AppTheme.colors.themeColors.backgroundSecondary,
        sheetShape = RoundedCornerShape(topStart = grid_x3, topEnd = grid_x3),
        scrimColor = scrimColor
    ) {
        content()
    }
}