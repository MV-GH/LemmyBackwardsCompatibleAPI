package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class RemovePost(
    val post_id: PostId,
    val removed: Boolean,
    val reason: String? = null,
    val auth: String,
)
