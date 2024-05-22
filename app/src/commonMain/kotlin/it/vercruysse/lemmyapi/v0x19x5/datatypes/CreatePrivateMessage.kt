package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreatePrivateMessage(
    val content: String,
    val recipient_id: PersonId,
)
