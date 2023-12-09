package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AddAdmin(
    val person_id: PersonId,
    val added: Boolean,
)
