package com.example.livevibe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.livevibe.ui.screen.HomeScreen
import com.example.livevibe.ui.theme.LiveVibeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LiveVibeTheme {
                HomeScreen()
            }
        }
    }
}
