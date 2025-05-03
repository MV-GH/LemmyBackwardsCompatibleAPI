package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PersonPostMention(
    val id: PersonPostMentionId,
    val recipient_id: PersonId,
    val post_id: PostId,
    val read: Boolean,
    val published: String,
)
