package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeletePost(
    val post_id: PostId,
    val deleted: Boolean,
)
