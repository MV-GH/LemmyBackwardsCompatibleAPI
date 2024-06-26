package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class DeletePost(
    val post_id: PostId,
    val deleted: Boolean,
    val auth: String,
)
