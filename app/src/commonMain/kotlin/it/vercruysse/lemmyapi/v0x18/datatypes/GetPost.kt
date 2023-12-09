package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPost(
    val id: PostId? = null,
    val comment_id: CommentId? = null,
    val auth: String? = null,
)
