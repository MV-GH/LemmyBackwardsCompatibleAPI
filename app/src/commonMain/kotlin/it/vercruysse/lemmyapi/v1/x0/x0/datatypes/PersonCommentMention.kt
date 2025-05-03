package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PersonCommentMention(
    val id: PersonCommentMentionId,
    val recipient_id: PersonId,
    val comment_id: CommentId,
    val read: Boolean,
    val published: String,
)
