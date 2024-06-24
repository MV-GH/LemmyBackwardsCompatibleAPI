package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetPost(
    val id: PostId? = null,
    val comment_id: CommentId? = null,
)
