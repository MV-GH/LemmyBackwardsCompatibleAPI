package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreatePostLike(
    val post_id: PostId,
    val score: Int,
)
