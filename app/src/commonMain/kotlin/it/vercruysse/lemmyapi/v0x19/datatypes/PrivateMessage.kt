package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessage(
    val id: PrivateMessageId,
    val creator_id: PersonId,
    val recipient_id: PersonId,
    val content: String,
    val deleted: Boolean,
    val read: Boolean,
    val published: String,
    val updated: String? = null,
    val ap_id: String,
    val local: Boolean,
)
