package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPersonDetails(
    val person_id: PersonId? = null,
    val username: String? = null,
)
