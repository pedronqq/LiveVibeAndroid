package com.pedronqq.livevibe.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

private val LiveVibeBackground = Color(0xFF1F1F1F)
private val LiveVibePurple = Color(0xFF8A33FC)

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onAddEvent: () -> Unit,
    onOpenNotifications: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier,
        topBar = {
            androidx.compose.material3.TopAppBar(
                title = {
                    Text(
                        text = "LiveVibe",
                        color = LiveVibePurple
                    )
                },
                actions = {
                    IconButton(onClick = onOpenNotifications) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notificações"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LiveVibeBackground)
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            when (val state = uiState) {
                HomeUiState.Loading -> CircularProgressIndicator()
                is HomeUiState.Error -> Text(
                    text = state.message,
                    color = MaterialTheme.colorScheme.error
                )
                is HomeUiState.Success -> {
                    Text(
                        text = "Shows: ${state.pastShows.size}",
                        color = Color.White
                    )
                    Text(
                        text = "Artistas: ${state.followedArtists.size}",
                        color = Color.White
                    )
                    Text(
                        text = "Próximos shows: ${state.upcomingShows.size}",
                        color = Color.White
                    )
                }
            }
        }
    }
}
