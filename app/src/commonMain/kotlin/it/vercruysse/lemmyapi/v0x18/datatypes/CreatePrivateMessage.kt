package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreatePrivateMessage(
    val content: String,
    val recipient_id: PersonId,
    val auth: String,
)
