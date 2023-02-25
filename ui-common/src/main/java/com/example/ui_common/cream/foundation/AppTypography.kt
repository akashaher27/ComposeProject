package com.example.ui_common.cream.foundation

import androidx.compose.material.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ui_common.R

@Immutable
class AppTypography internal constructor(
    val display1: TextStyle,
    val display2: TextStyle,
    val display3: TextStyle,
    val display4: TextStyle,
    val display5: TextStyle,
    val heading1: TextStyle,
    val heading2: TextStyle,
    val heading3: TextStyle,
    val heading4: TextStyle,
    val heading5: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,
    val callout1: TextStyle,
    val callout2: TextStyle,
    val callout3: TextStyle,
    val metadata1: TextStyle,
    val metadata1SemiBold: TextStyle,
    val metadata2: TextStyle
) {
    constructor(
        defaultFontFamily: FontFamily = DEFAULT_FONT_FAMILY,
        display1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 80.sp,
            lineHeight = 88.sp
        ),
        display2: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 72.sp,
            lineHeight = 80.sp
        ),
        display3: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 64.sp,
            lineHeight = 72.sp
        ),
        display4: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 56.sp,
            lineHeight = 64.sp
        ),
        display5: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 48.sp,
            lineHeight = 56.sp
        ),
        heading1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 40.sp,
            lineHeight = 44.sp
        ),
        heading2: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            lineHeight = 40.sp
        ),
        heading3: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            lineHeight = 32.sp
        ),
        heading4: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 28.sp
        ),
        heading5: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            lineHeight = 24.sp
        ),
        body1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            lineHeight = 28.sp
        ),
        body2: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp
        ),
        body3: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
        callout1: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 24.sp
        ),
        callout2: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            lineHeight = 20.sp
        ),
        callout3: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
        metadata1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp
        ),
        metadata1SemiBold: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            lineHeight = 16.sp
        ),
        metadata2: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            lineHeight = 12.sp
        )
    ) : this(
        display1 = display1.withDefaultFontFamily(defaultFontFamily),
        display2 = display2.withDefaultFontFamily(defaultFontFamily),
        display3 = display3.withDefaultFontFamily(defaultFontFamily),
        display4 = display4.withDefaultFontFamily(defaultFontFamily),
        display5 = display5.withDefaultFontFamily(defaultFontFamily),
        heading1 = heading1.withDefaultFontFamily(defaultFontFamily),
        heading2 = heading2.withDefaultFontFamily(defaultFontFamily),
        heading3 = heading3.withDefaultFontFamily(defaultFontFamily),
        heading4 = heading4.withDefaultFontFamily(defaultFontFamily),
        heading5 = heading5.withDefaultFontFamily(defaultFontFamily),
        body1 = body1.withDefaultFontFamily(defaultFontFamily),
        body2 = body2.withDefaultFontFamily(defaultFontFamily),
        body3 = body3.withDefaultFontFamily(defaultFontFamily),
        callout1 = callout1.withDefaultFontFamily(defaultFontFamily),
        callout2 = callout2.withDefaultFontFamily(defaultFontFamily),
        callout3 = callout3.withDefaultFontFamily(defaultFontFamily),
        metadata1 = metadata1.withDefaultFontFamily(defaultFontFamily),
        metadata1SemiBold = metadata1SemiBold.withDefaultFontFamily(defaultFontFamily),
        metadata2 = metadata2.withDefaultFontFamily(defaultFontFamily)
    )

    val materialTypography: Typography
        // relations can be changed when it needs
        get() = Typography(
            defaultFontFamily = DEFAULT_FONT_FAMILY,
            h1 = display1,
            h2 = display3,
            h3 = display5,
            h4 = heading2,
            h5 = heading3,
            h6 = heading4,
            subtitle1 = callout2,
            subtitle2 = callout3,
            body1 = body2,
            body2 = body3,
            button = callout3,
            caption = metadata1,
            overline = metadata2
        )


    companion object {
        // Add more fonts to the family when it needs
        private val DEFAULT_FONT_FAMILY = FontFamily(
            Font(R.font.inter_regular_400, weight = FontWeight.Normal)
        )
    }
}

private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}

internal const val DEFAULT_FONT_FAMILY_NAME = "Inter"
