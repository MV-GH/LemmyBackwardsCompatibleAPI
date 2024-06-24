package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreatePrivateMessage(
    val content: String,
    val recipient_id: PersonId,
)
