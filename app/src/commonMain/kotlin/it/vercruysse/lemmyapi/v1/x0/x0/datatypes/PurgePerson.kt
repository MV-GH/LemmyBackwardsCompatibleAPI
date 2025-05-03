package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PurgePerson(
    val person_id: PersonId,
    val reason: String? = null,
)
