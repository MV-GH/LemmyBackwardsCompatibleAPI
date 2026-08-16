package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AddAdmin(
    val person_id: PersonId,
    val added: Boolean,
)
