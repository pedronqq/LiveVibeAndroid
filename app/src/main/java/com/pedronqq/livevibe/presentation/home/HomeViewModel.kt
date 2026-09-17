package com.pedronqq.livevibe.presentation.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Success())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun removeArtist(artistId: String) {
        val current = _uiState.value
        if (current is HomeUiState.Success) {
            _uiState.value = current.copy(
                followedArtists = current.followedArtists.filterNot { it.id == artistId }
            )
        }
    }

    fun setUnreadNotifications(hasUnread: Boolean) {
        val current = _uiState.value
        if (current is HomeUiState.Success) {
            _uiState.value = current.copy(hasUnreadNotifications = hasUnread)
        }
    }
}
