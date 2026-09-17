package com.pedronqq.livevibe.data.model

import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class UpcomingShow(
    val id: String = UUID.randomUUID().toString(),
    val artist: String,
    val tourName: String? = null,
    val location: String,
    val dateEpochMillis: Long
)

@Serializable
data class SavedArtist(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val isOnTour: Boolean = false
)

@Serializable
data class PastShow(
    val id: String = UUID.randomUUID().toString(),
    val artist: String,
    val tourName: String,
    val date: String,
    val rating: Int,
    val colorName: String,
    val isFestival: Boolean,
    val gotBarricade: Boolean,
    val metArtist: Boolean,
    val genre: String,
    val address: String,
    val structureRating: Int? = null,
    val selectedMoods: List<String>? = null,
    val friends: List<String>? = null,
    val gotDrumstick: Boolean? = null,
    val gotConfetti: Boolean? = null,
    val gotSetlist: Boolean? = null,
    val gotPick: Boolean? = null,
    val isTraveler: Boolean? = null,
    val hoursInLine: Double? = null,
    val isFirstShow: Boolean = false,
    val becameFan: Boolean = false,
    val shortReview: String = ""
)

@Serializable
data class SpotifyImage(val url: String)

@Serializable
data class SpotifyArtist(
    val id: String,
    val name: String,
    val images: List<SpotifyImage>? = null,
    val genres: List<String>? = null
)

@Serializable
data class SpotifySearchResult(
    val artists: SpotifyArtists
) {
    @Serializable
    data class SpotifyArtists(val items: List<SpotifyArtist>)
}

@Serializable
data class SpotifyTrack(
    val id: String,
    val name: String,
    val preview_url: String? = null
)

@Serializable
data class SetlistResponse(
    val setlist: List<SetlistData>? = null
)

@Serializable
data class SetlistData(
    val id: String,
    val eventDate: String,
    val artist: SetlistArtist? = null,
    val venue: SetlistVenue? = null,
    val tour: SetlistTour? = null
)

@Serializable
data class SetlistArtist(val name: String)

@Serializable
data class SetlistVenue(
    val name: String,
    val city: SetlistCity? = null
)

@Serializable
data class SetlistCity(
    val name: String,
    val country: SetlistCountry? = null
)

@Serializable
data class SetlistCountry(val name: String)

@Serializable
data class SetlistTour(val name: String)

@Serializable
data class TicketmasterResponse(
    val embedded: TicketmasterEmbedded? = null
)

@Serializable
data class TicketmasterEmbedded(
    val events: List<TicketmasterEvent>? = null
)

@Serializable
data class TicketmasterEvent(
    val name: String,
    val dates: TicketmasterDates? = null,
    val embedded: TicketmasterEventEmbedded? = null
)

@Serializable
data class TicketmasterDates(val start: TicketmasterStart? = null)

@Serializable
data class TicketmasterStart(val localDate: String? = null)

@Serializable
data class TicketmasterEventEmbedded(
    val venues: List<TicketmasterVenue>? = null
)

@Serializable
data class TicketmasterVenue(
    val name: String? = null,
    val city: TicketmasterCity? = null,
    val country: TicketmasterCountry? = null
)

@Serializable
data class TicketmasterCity(val name: String? = null)

@Serializable
data class TicketmasterCountry(val name: String? = null)
