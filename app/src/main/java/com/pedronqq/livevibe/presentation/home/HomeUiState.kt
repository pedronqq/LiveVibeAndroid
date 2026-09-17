package com.pedronqq.livevibe.presentation.home

import com.pedronqq.livevibe.data.model.PastShow
import com.pedronqq.livevibe.data.model.SavedArtist
import com.pedronqq.livevibe.data.model.UpcomingShow

sealed interface HomeUiState {
    data object Loading : HomeUiState

    data class Success(
        val upcomingShows: List<UpcomingShow> = emptyList(),
        val followedArtists: List<SavedArtist> = emptyList(),
        val pastShows: List<PastShow> = emptyList(),
        val hasUnreadNotifications: Boolean = false
    ) : HomeUiState

    data class Error(val message: String) : HomeUiState
}
