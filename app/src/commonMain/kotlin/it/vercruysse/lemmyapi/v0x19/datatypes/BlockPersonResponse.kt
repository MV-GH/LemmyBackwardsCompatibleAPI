package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockPersonResponse(
    val person_view: PersonView,
    val blocked: Boolean,
)
