package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BannedPersonsResponse(
    val banned: List<PersonView>,
)
