package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreatePostLike(
    val post_id: PostId,
    val score: Int,
)
