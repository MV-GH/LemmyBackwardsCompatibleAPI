package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PersonMention(
    val id: PersonMentionId,
    val recipient_id: PersonId,
    val comment_id: CommentId,
    val read: Boolean,
    val published: String,
)
