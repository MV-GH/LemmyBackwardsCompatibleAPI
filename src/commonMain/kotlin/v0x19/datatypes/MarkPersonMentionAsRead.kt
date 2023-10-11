package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class MarkPersonMentionAsRead(
    val person_mention_id: PersonMentionId,
    val read: Boolean,
)
