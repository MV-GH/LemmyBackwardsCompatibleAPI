package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BannedPersonsResponse(
    val banned: List<PersonView>,
)
