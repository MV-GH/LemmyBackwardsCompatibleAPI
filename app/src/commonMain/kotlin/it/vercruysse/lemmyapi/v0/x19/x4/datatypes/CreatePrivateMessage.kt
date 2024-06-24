package it.vercruysse.lemmyapi.v0.x19.x4.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreatePrivateMessage(
    val content: String,
    val recipient_id: PersonId,
)
