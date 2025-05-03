package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class MarkPersonPostMentionAsRead(
    val person_post_mention_id: PersonPostMentionId,
    val read: Boolean,
)
