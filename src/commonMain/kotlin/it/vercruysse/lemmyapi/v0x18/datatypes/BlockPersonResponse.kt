package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class BlockPersonResponse(
    val person_view: PersonView,
    val blocked: Boolean,
)
