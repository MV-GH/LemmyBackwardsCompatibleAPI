package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class MarkPersonMentionAsRead(
    val person_mention_id: PersonMentionId,
    val read: Boolean,
)
