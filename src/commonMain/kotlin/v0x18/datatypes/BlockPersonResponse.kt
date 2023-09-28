package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockPersonResponse(
    val person_view: PersonView,
    val blocked: Boolean,
)
