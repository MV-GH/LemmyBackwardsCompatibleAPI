package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AddAdmin(
    val person_id: PersonId,
    val added: Boolean,
)
