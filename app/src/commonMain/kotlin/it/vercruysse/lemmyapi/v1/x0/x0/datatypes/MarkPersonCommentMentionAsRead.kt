package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class MarkPersonCommentMentionAsRead(
    val person_comment_mention_id: PersonCommentMentionId,
    val read: Boolean,
)
