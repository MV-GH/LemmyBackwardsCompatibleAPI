package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BanFromCommunityResponse(
    val person_view: PersonView,
    val banned: Boolean,
)
