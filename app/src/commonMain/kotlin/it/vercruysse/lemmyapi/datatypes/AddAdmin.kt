package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AddAdmin(
    val person_id: PersonId,
    val added: Boolean,
)
