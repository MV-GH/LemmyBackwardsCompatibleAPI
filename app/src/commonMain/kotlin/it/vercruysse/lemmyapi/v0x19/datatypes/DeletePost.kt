package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeletePost(
    val post_id: PostId,
    val deleted: Boolean,
)
