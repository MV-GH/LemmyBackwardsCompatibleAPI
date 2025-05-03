package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PersonActions(
    val target_id: PersonId,
    val person_id: PersonId,
    val blocked: String? = null,
)
