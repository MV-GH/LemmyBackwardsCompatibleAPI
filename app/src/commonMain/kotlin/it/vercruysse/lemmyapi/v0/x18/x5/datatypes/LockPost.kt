package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LockPost(
    val post_id: PostId,
    val locked: Boolean,
    val auth: String,
)
