package com.pedronqq.livevibe.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LiveVibeDarkColors = darkColorScheme(
    primary = Color(0xFF8A33FC),
    background = Color(0xFF1F1F1F),
    surface = Color(0xFF1F1F1F)
)

@Composable
fun LiveVibeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LiveVibeDarkColors,
        content = content
    )
}
