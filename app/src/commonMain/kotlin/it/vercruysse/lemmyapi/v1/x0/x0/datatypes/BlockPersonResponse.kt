package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class BlockPersonResponse(
    val person_view: PersonView,
    val blocked: Boolean,
)
