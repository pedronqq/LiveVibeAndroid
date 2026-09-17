package com.pedronqq.livevibe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pedronqq.livevibe.presentation.home.HomeScreen
import com.pedronqq.livevibe.presentation.home.HomeViewModel
import com.pedronqq.livevibe.ui.theme.LiveVibeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LiveVibeTheme {
                val homeViewModel: HomeViewModel = viewModel()
                HomeScreen(
                    viewModel = homeViewModel,
                    onAddEvent = {},
                    onOpenNotifications = {}
                )
            }
        }
    }
}
