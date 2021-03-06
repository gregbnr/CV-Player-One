package com.gregoirebonnier.cvplayerone.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = Orange500,
    primaryVariant = Orange700,
    //secondary = Teal200,
    background = Grey200,
    surface = Color.White,
    onPrimary = Color.White,
    //onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

private val DarkColorPalette = darkColors(
    primary = Orange500,
    primaryVariant = Orange700,
    //secondary = Teal200,
    background = Grey200,
    surface = Blue900,
    onPrimary = Blue900,
    //onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
)

@Composable
fun CVPlayerOneTheme(isDarkMode: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (isDarkMode) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}