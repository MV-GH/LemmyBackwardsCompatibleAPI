package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPost(
    val id: PostId? = null,
    val comment_id: CommentId? = null,
)
