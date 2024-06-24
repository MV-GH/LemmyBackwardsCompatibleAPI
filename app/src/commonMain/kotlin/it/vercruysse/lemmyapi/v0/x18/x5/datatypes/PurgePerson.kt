package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PurgePerson(
    val person_id: PersonId,
    val reason: String? = null,
    val auth: String,
)
