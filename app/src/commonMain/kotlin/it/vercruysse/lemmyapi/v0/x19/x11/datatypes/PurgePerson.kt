package it.vercruysse.lemmyapi.v0.x19.x11.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PurgePerson(
    val person_id: PersonId,
    val reason: String? = null,
)
