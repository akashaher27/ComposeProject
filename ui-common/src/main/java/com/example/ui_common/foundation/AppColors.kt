package com.example.ui_common.foundation

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

object AppColors {
    val Neon = mapOf(
        50 to Color(0xFFD2BFF4),
        100 to Color(0xFFAF89F4),
        300 to Color(0xFF8653E3),
        500 to Color(0xFF771fFF)
    )

    val Eggplant = mapOf(
        50 to Color(0xFF8173A0),
        100 to Color(0xFF443B59),
        200 to Color(0xFF332B44),
        300 to Color(0xFF272036),
        500 to Color(0xFF0C0120)
    )

    val Pearl = mapOf(
        100 to Color(0xFFE9E9E9),
        500 to Color(0xFFFAFAFA)
    )

    val Black = mapOf(
        100 to Color(0xFF878787),
        200 to Color(0xFF595959),
        500 to Color(0xFF000000)
    )

    val Mint = mapOf(
        500 to Color(0xFF75F9AA)
    )

    val Gum = mapOf(
        100 to Color(0xFFF8316D)
    )

    val Thunder = mapOf(
        500 to Color(0xFFFFD500)
    )

    val Bolt = mapOf(
        500 to Color(0xFF4CC9F0)
    )

    val themeColors = ThemeColors(
        brandPrimary = Neon[500]!!,
        brandSecondary = Neon[300]!!,
        brandTertiary = Neon[100]!!,
        backgroundPrimary = Eggplant[500]!!,
        backgroundSecondary = Eggplant[300]!!,
        backgroundTertiary = Eggplant[100]!!,
        backgroundDisabled = Eggplant[200]!!,
        backgroundScrim = Black[500]!!.copy(alpha = 0.75f),
        backgroundCarousel = Black[200]!!,
        textPrimary = Pearl[500]!!,
        textSecondary = Pearl[100]!!,
        textTertiary = Black[100]!!,
        textDisabled = Pearl[500]!!.copy(alpha = 0.2f),
        textPlaceholder = Eggplant[50]!!,
        textLink = Neon[100]!!,
        statusSuccess = Mint[500]!!,
        statusError = Gum[100]!!,
        statusAlert = Thunder[500]!!,
        statusInformation = Bolt[500]!!
    )

    @Immutable
    data class ThemeColors(
        val brandPrimary: Color,
        val brandSecondary: Color,
        val brandTertiary: Color,

        val backgroundPrimary: Color,
        val backgroundSecondary: Color,
        val backgroundTertiary: Color,
        val backgroundDisabled: Color,
        val backgroundScrim: Color,
        val backgroundCarousel: Color,

        val textPrimary: Color,
        val textSecondary: Color,
        val textTertiary: Color,
        val textDisabled: Color,
        val textPlaceholder: Color,
        val textLink: Color,

        val statusSuccess: Color,
        val statusError: Color,
        val statusAlert: Color,
        val statusInformation: Color
    )

    val materialColors: Colors = darkColors(
        primary = themeColors.brandPrimary,
        primaryVariant = themeColors.brandSecondary,
        secondary = themeColors.brandTertiary,
        background = themeColors.backgroundPrimary,
        surface = themeColors.backgroundSecondary,
        error = themeColors.statusError,
        onPrimary = themeColors.textPrimary,
        onSecondary = themeColors.textSecondary,
        onBackground = themeColors.textPrimary,
        onSurface = themeColors.textPrimary,
        onError = themeColors.textPrimary
    )


}