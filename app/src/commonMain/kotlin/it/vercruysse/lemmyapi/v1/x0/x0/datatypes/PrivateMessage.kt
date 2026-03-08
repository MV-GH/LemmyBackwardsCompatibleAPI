package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("private_message")
internal data class PrivateMessage(
    val id: PrivateMessageId,
    val creator_id: PersonId,
    val recipient_id: PersonId,
    val content: String,
    val deleted: Boolean,
    val published_at: String,
    val updated_at: String? = null,
    val ap_id: DbUrl,
    val local: Boolean,
    val removed: Boolean,
) : PostOrCommentOrPrivateMessage
