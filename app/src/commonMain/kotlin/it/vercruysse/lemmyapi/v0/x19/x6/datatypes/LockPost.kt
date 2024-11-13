package it.vercruysse.lemmyapi.v0.x19.x6.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LockPost(
    val post_id: PostId,
    val locked: Boolean,
)
