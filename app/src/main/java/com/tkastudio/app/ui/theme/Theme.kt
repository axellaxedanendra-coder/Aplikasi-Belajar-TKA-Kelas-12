package com.tkastudio.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object MonoColors {
    val BgCanvas = Color(0xFF09090B)
    val BgDrawer = Color(0xFF0E0E11)
    val BgSurface = Color(0xFF111113)
    val BgCode = Color(0xFF000000)
    val BgInset = Color(0xFF18181B)
    val Border = Color(0xFF27272A)
    val BorderStrong = Color(0xFF3F3F46)
    val PureWhite = Color(0xFFFFFFFF)
    val TextPrimary = Color(0xFFFAFAFA)
    val TextSecondary = Color(0xFFD4D4D8)
    val TextMuted = Color(0xFFA1A1AA)
    val TextDim = Color(0xFF71717A)
}

private val MonochromeDarkScheme = darkColorScheme(
    primary = MonoColors.PureWhite,
    onPrimary = MonoColors.BgCanvas,
    secondary = MonoColors.TextSecondary,
    onSecondary = MonoColors.BgCanvas,
    background = MonoColors.BgCanvas,
    onBackground = MonoColors.TextPrimary,
    surface = MonoColors.BgSurface,
    onSurface = MonoColors.TextPrimary,
    surfaceVariant = MonoColors.BgInset,
    onSurfaceVariant = MonoColors.TextMuted,
    outline = MonoColors.Border
)

private val MonochromeTypography = Typography(
    headlineMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
        lineHeight = 30.sp,
        letterSpacing = (-0.5).sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 19.sp,
        lineHeight = 25.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 22.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 14.sp,
        lineHeight = 21.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    )
)

@Composable
fun TkaStudioTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MonochromeDarkScheme,
        typography = MonochromeTypography,
        content = content
    )
}
