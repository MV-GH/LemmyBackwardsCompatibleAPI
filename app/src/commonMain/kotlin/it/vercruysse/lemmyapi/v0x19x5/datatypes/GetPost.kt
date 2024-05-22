package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetPost(
    val id: PostId? = null,
    val comment_id: CommentId? = null,
)
