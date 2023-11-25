package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AddAdmin(
    val person_id: PersonId,
    val added: Boolean,
    val auth: String,
)
