package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PurgePerson(
    val person_id: PersonId,
    val reason: String? = null,
)
