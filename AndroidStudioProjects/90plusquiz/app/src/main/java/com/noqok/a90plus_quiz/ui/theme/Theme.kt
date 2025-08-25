package com.noqok.a90plus_quiz.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val AppColorScheme = darkColorScheme(
    primary = PrimaryBlue,
    secondary = AccentYellow,
    background = Dark900,
    onPrimary = TextHighEmphasis,
    onSecondary = TextHighEmphasis,
    onBackground = TextHighEmphasis,
    surface = Dark800,
    onSurface = TextHighEmphasis
)

@Composable
fun _90plusquizTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography,
        content = content
    )
}
